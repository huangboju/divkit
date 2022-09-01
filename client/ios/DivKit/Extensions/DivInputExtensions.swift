import CoreFoundation
import CoreGraphics
import Foundation

import BaseUI
import CommonCore
import LayoutKit

extension DivInput: DivBlockModeling {
  public func makeBlock(context: DivBlockModelingContext) throws -> Block {
    try applyBaseProperties(
      to: { try makeBaseBlock(context: context) },
      context: context,
      actions: nil,
      actionAnimation: nil,
      doubleTapActions: nil,
      longTapActions: nil
    )
  }

  private func makeBaseBlock(context: DivBlockModelingContext) throws -> Block {
    let font = context.fontSpecifiers.font(
      family: resolveFontFamily(context.expressionResolver).fontFamily,
      weight: resolveFontWeight(context.expressionResolver).fontWeight,
      size: resolveFontSizeUnit(context.expressionResolver)
        .makeScaledValue(resolveFontSize(context.expressionResolver))
    )
    var typo = Typo(font: font).allowHeightOverrun

    let verticalAlignment = resolveAlignmentVertical(context.expressionResolver) ?? .top
    let horizontalAlignment = resolveAlignmentHorizontal(context.expressionResolver) ?? .left

    let textAlignment = horizontalAlignment.system
    if textAlignment != .left {
      typo = typo.with(alignment: textAlignment)
    }

    let kern = CGFloat(resolveLetterSpacing(context.expressionResolver))
    if !kern.isApproximatelyEqualTo(0) {
      typo = typo.kerned(kern)
    }

    if let lineHeight = resolveLineHeight(context.expressionResolver) {
      typo = typo.with(height: CGFloat(lineHeight))
    }

    let resolvedHintColor: Color = resolveHintColor(context.expressionResolver)
    let hintTypo = typo.with(color: resolvedHintColor)
    let hintValue = resolveHintText(context.expressionResolver) ?? ""

    let resolvedColor: Color = resolveTextColor(context.expressionResolver)
    let textTypo = typo.with(color: resolvedColor)

    let textValue = Binding<String>(context: context, name: textVariable)

    let highlightColor = resolveHighlightColor(context.expressionResolver)

    let keyboardType = resolveKeyboardType(context.expressionResolver)

    let maxVisibleLines = resolveMaxVisibleLines(context.expressionResolver)

    let selectAllOnFocus = resolveSelectAllOnFocus(context.expressionResolver)

    let contentMode = makeContentMode(verticalAlignment: verticalAlignment,
                                      horizontalAlignment: horizontalAlignment)
    let onFocusActions = (focus?.onFocus ?? []).map {
      $0.uiAction(context: context.actionContext)
    }
    let onBlurActions = (focus?.onBlur ?? []).map {
      $0.uiAction(context: context.actionContext)
    }

    return TextInputBlock(
      widthTrait: makeContentWidthTrait(with: context.expressionResolver),
      heightTrait: makeContentHeightTrait(with: context.expressionResolver),
      hint: hintValue.with(typo: hintTypo),
      textValue: textValue,
      textTypo: textTypo,
      multiLineMode: keyboardType == .multiLineText,
      keyboardType: keyboardType.system,
      highlightColor: highlightColor,
      maxVisibleLines: maxVisibleLines,
      selectAllOnFocus: selectAllOnFocus,
      contentMode: contentMode,
      path: context.parentPath,
      onFocusActions: onFocusActions,
      onBlurActions: onBlurActions,
      parentScrollView: context.parentScrollView
    )
  }

  private func makeContentMode(
    verticalAlignment: DivAlignmentVertical,
    horizontalAlignment: DivAlignmentHorizontal
  ) -> TextInputBlock.ContentMode {
    switch (verticalAlignment, horizontalAlignment) {
    case (.top, .left):
      return .topLeft
    case (.center, .left):
      return .left
    case (.bottom, .left):
      return .bottomLeft
    case (.top, .center):
      return .top
    case (.center, .center):
      return .center
    case (.bottom, .center):
      return .bottom
    case (.top, .right):
      return .topRight
    case (.center, .right):
      return .right
    case (.bottom, .right):
      return .bottomRight
    }
  }
}

extension DivAlignmentHorizontal {
  fileprivate var system: TextAlignment {
    switch self {
    case .left:
      return .left
    case .center:
      return .center
    case .right:
      return .right
    }
  }
}

extension DivInput.KeyboardType {
  fileprivate var system: TextInputBlock.KeyboardType {
    switch self {
    case .singleLineText, .multiLineText:
      return .default
    case .phone:
      return .phonePad
    case .number:
      return .numbersAndPunctuation
    case .email:
      return .emailAddress
    case .uri:
      return .URL
    }
  }
}
