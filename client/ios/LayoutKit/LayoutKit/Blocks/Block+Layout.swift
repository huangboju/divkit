import CoreGraphics
import Foundation

import CommonCore

public struct ContainerBlockLayout {
  private enum ContentFitting {
    case fits
    case doesNotFit(notFittingPartSize: CGFloat)

    init(offsets: [CGFloat], margin: CGFloat) {
      let minOffset = offsets.min()! - margin
      if minOffset.isApproximatelyLessThan(0) {
        self = .doesNotFit(notFittingPartSize: -minOffset)
      } else {
        self = .fits
      }
    }

    var insetValue: CGFloat {
      switch self {
      case .fits:
        return 0
      case let .doesNotFit(notFittingPartSize: inset):
        return inset
      }
    }
  }

  public private(set) var childrenWithSeparators: [ContainerBlock.Child] = []
  public private(set) var blockFrames: [CGRect] = []
  let gaps: [CGFloat]
  let layoutDirection: ContainerBlock.LayoutDirection
  let layoutMode: ContainerBlock.LayoutMode
  let axialAlignment: Alignment
  let size: CGSize

  public init(
    children: [ContainerBlock.Child],
    separator: ContainerBlock.Separator? = nil,
    lineSeparator: ContainerBlock.Separator? = nil,
    gaps: [CGFloat],
    layoutDirection: ContainerBlock.LayoutDirection,
    layoutMode: ContainerBlock.LayoutMode,
    axialAlignment: Alignment,
    size: CGSize
  ) {
    precondition(gaps.count == children.count + 1)
    self.gaps = gaps
    self.layoutDirection = layoutDirection
    self.layoutMode = layoutMode
    self.axialAlignment = axialAlignment
    self.size = size
    (self.childrenWithSeparators, self.blockFrames) = calculateBlockFrames(
      children: children,
      separator: separator,
      lineSeparator: lineSeparator
    )
  }

  private func calculateBlockFrames(
    children: [ContainerBlock.Child],
    separator: ContainerBlock.Separator? = nil,
    lineSeparator: ContainerBlock.Separator? = nil
  ) -> ([ContainerBlock.Child], [CGRect]) {
    switch layoutMode {
    case .noWrap:
      return calculateNoWrapLayoutFrames(
        children: children
      )
    case .wrap:
      return calculateWrapLayoutFrames(
        children: children,
        separator: separator,
        lineSeparator: lineSeparator
      )
    }
  }

  private func calculateNoWrapLayoutFrames(
    children: [ContainerBlock.Child]
  ) -> ([ContainerBlock.Child], [CGRect]) {
    var frames = [CGRect]()
    let gapsSize = gaps.reduce(0, +)
    var shift = CGPoint(x: 0, y: 0)
    switch layoutDirection {
    case .horizontal:
      let horizontallyResizableBlocks = children.map { $0.content }
        .filter { $0.isHorizontallyResizable }
      let widthOfHorizontallyNonResizableBlocks =
      widthsOfHorizontallyNonResizableBlocksIn(children.map { $0.content }).reduce(0,+)
      let widthAvailableForResizableBlocks = (
        size.width - widthOfHorizontallyNonResizableBlocks - gapsSize
      )
      let resizableBlockWeights = horizontallyResizableBlocks
        .map { $0.weightOfHorizontallyResizableBlock.rawValue }
      let widthAvailablePerWeightUnit = max(0, widthAvailableForResizableBlocks) /
        resizableBlockWeights.reduce(0, +)

      var blockMeasure = ResizableBlockMeasure(
        resizableBlockCount: horizontallyResizableBlocks.count,
        lengthAvailablePerWeightUnit: widthAvailablePerWeightUnit,
        lengthAvailableForResizableBlocks: widthAvailableForResizableBlocks
      )

      var x = gaps[0]
      zip(children, gaps.dropFirst()).forEach { child, gapAfterBlock in
        let block = child.content
        let widthIfResizable = blockMeasure.measureNext(block.horizontalMeasure)
        var blockSize = block.sizeFor(
          widthOfHorizontallyResizableBlock: widthIfResizable,
          heightOfVerticallyResizableBlock: size.height
        )
        if block.isVerticallyConstrained, blockSize.height > size.height {
          blockSize.height = size.height
        }
        if widthAvailableForResizableBlocks < 0, block.isHorizontallyConstrained {
          blockSize.width = max(
            blockSize.width + widthAvailableForResizableBlocks, 0
          )
        }
        let alignmentSpace = size.height - blockSize.height
        let y = child.crossAlignment.offset(forAvailableSpace: alignmentSpace)
        frames.append(CGRect(origin: CGPoint(x: x, y: y), size: blockSize))
        x += blockSize.width + gapAfterBlock
      }
      shift.x = axialAlignment.offset(forAvailableSpace: size.width, contentSize: x)
    case .vertical:
      let verticallyResizableBlocks = children.map { $0.content }
        .filter { $0.isVerticallyResizable }
      let heightOfVerticallyNonResizableBlocks =
      heightsOfVerticallyNonResizableBlocksIn(children.map { $0.content }, forWidth: size.width).reduce(0, +)
      let heightAvailableForResizableBlocks = (
        size.height - heightOfVerticallyNonResizableBlocks - gapsSize
      )
      let resizableBlockWeights = verticallyResizableBlocks
        .map { $0.weightOfVerticallyResizableBlock.rawValue }
      let heightAvailablePerWeightUnit = max(0, heightAvailableForResizableBlocks) /
        resizableBlockWeights.reduce(0, +)
      var y = gaps[0]
      var blockMeasure = ResizableBlockMeasure(
        resizableBlockCount: verticallyResizableBlocks.count,
        lengthAvailablePerWeightUnit: heightAvailablePerWeightUnit,
        lengthAvailableForResizableBlocks: heightAvailableForResizableBlocks
      )
      zip(children, gaps.dropFirst()).forEach { child, gapAfterBlock in
        let block = child.content
        let width = (block.isHorizontallyResizable || block.isHorizontallyConstrained)
          ? size.width
          : block.widthOfHorizontallyNonResizableBlock
        let alignmentSpace = size.width - width
        let x = child.crossAlignment.offset(forAvailableSpace: alignmentSpace)
        let heightIfResizable = blockMeasure.measureNext(block.verticalMeasure)
        var height = block.isVerticallyResizable
          ? heightIfResizable
          : block.heightOfVerticallyNonResizableBlock(forWidth: width)
        if heightAvailableForResizableBlocks < 0, block.isVerticallyConstrained {
          height = max(height + heightAvailableForResizableBlocks, 0)
        }
        frames.append(CGRect(x: x, y: y, width: width, height: height))
        y += height + gapAfterBlock
      }
      shift.y = axialAlignment.offset(forAvailableSpace: size.height, contentSize: y)
    }

    return (children, frames.map {
      let frame = $0.offset(by: shift).roundedToScreenScale
      precondition(frame.isValidAndFinite)
      return frame
    })
  }

  private func calculateWrapLayoutFrames(
    children: [ContainerBlock.Child],
    separator: ContainerBlock.Separator?,
    lineSeparator: ContainerBlock.Separator?
  ) -> ([ContainerBlock.Child], [CGRect]) {
    #if INTERNAL_BUILD
    assert(gaps.allSatisfy { $0.isApproximatelyEqualTo(0) }, "You cannot use gaps in wrap container.")
    assert(
      !children
        .contains { $0.content.isHorizontallyResizable || $0.content.isVerticallyResizable
        },
      "You cannot use resizable blocks in wrap container."
    )
    #endif
    var frames = [CGRect]()
    let buildingDirectionKeyPath = layoutDirection.buildingDirectionKeyPath
    let transferDirectionKeyPath = layoutDirection.transferDirectionKeyPath

    let wrapLayoutGroups = WrapLayoutGroups(
      children: children,
      separator: separator,
      lineSeparator: lineSeparator,
      size: size,
      layoutDirection: layoutDirection
    )

    var currentLineOffset = 0.0
    wrapLayoutGroups.groups.forEach {
      let groupHeight = $0.map(\.childSize).map(to: transferDirectionKeyPath).max() ?? 0
      let contentLength = $0.map(\.childSize).map(to: buildingDirectionKeyPath).reduce(0, +)

      $0.forEach {
        let alignmentSpace = groupHeight - $0.childSize[keyPath: transferDirectionKeyPath]
        let alignedLineOffset = currentLineOffset + $0.child.crossAlignment
          .offset(forAvailableSpace: alignmentSpace)
        let alignedElementOffset = $0.lineOffset.advanced(by: axialAlignment.offset(
          forAvailableSpace: size[keyPath: buildingDirectionKeyPath],
          contentSize: contentLength
        ).roundedToScreenScale)

        switch layoutDirection {
        case .horizontal:
          frames
            .append(CGRect(origin: CGPoint(
              x: alignedElementOffset,
              y: alignedLineOffset
            ), size: $0.childSize))
        case .vertical:
          frames
            .append(CGRect(origin: CGPoint(
              x: alignedLineOffset,
              y: alignedElementOffset
            ), size: $0.childSize))
        }
      }

      currentLineOffset += groupHeight
    }
    return (wrapLayoutGroups.childrenWithSeparators, frames)
  }

  public var leftInset: CGFloat {
    let leftMargin = layoutDirection == .horizontal ? gaps.first! : 0
    return ContentFitting(
      offsets: blockFrames.map { $0.minX },
      margin: leftMargin
    ).insetValue
  }

  public var topInset: CGFloat {
    let topMargin = layoutDirection == .vertical ? gaps.first! : 0
    return ContentFitting(
      offsets: blockFrames.map { $0.minY },
      margin: topMargin
    ).insetValue
  }

  public var bottomInset: CGFloat { layoutDirection == .vertical ? gaps.last! : 0 }
  public var rightInset: CGFloat { layoutDirection == .horizontal ? gaps.last! : 0 }

  public var contentSize: CGSize {
    CGSize(
      width: blockFrames.map { $0.maxX }.max()!,
      height: blockFrames.map { $0.maxY }.max()!
    )
  }
}

private func heightsOfVerticallyNonResizableBlocksIn(_ blocks: [Block], forWidth width: CGFloat) -> [CGFloat] {
  blocks.filter { !$0.isVerticallyResizable }.map { $0.heightOfVerticallyNonResizableBlock(forWidth: width) }
}

func widthsOfHorizontallyNonResizableBlocksIn(_ blocks: [Block]) -> [CGFloat] {
  blocks.filter { !$0.isHorizontallyResizable }.map { $0.widthOfHorizontallyNonResizableBlock }
}

extension Block {
  fileprivate var horizontalMeasure: ResizableBlockMeasure.Measure {
    isHorizontallyResizable ? .resizable(weightOfHorizontallyResizableBlock) : .nonResizable
  }
  
  fileprivate var verticalMeasure: ResizableBlockMeasure.Measure {
    isVerticallyResizable ? .resizable(weightOfVerticallyResizableBlock) : .nonResizable
  }
}
