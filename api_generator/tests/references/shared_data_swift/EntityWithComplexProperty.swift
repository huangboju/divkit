// Generated code. Do not modify.

import CommonCore
import Foundation
import Serialization

public final class EntityWithComplexProperty {
  public final class Property {
    public let value: Expression<URL>

    public func resolveValue(_ resolver: ExpressionResolver) -> URL? {
      resolver.resolveStringBasedValue(expression: value, initializer: URL.init(string:))
    }

    init(
      value: Expression<URL>
    ) {
      self.value = value
    }
  }

  public static let type: String = "entity_with_complex_property"
  public let property: Property

  init(
    property: Property
  ) {
    self.property = property
  }
}

#if DEBUG
extension EntityWithComplexProperty: Equatable {
  public static func ==(lhs: EntityWithComplexProperty, rhs: EntityWithComplexProperty) -> Bool {
    guard
      lhs.property == rhs.property
    else {
      return false
    }
    return true
  }
}
#endif

#if DEBUG
extension EntityWithComplexProperty.Property: Equatable {
  public static func ==(lhs: EntityWithComplexProperty.Property, rhs: EntityWithComplexProperty.Property) -> Bool {
    guard
      lhs.value == rhs.value
    else {
      return false
    }
    return true
  }
}
#endif
