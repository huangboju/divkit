// Generated code. Do not modify.

import CommonCore
import Foundation
import Serialization

public final class EntityWithOptionalProperty {
  public static let type: String = "entity_with_optional_property"
  public let property: Expression<String>? // at least 1 char

  public func resolveProperty(_ resolver: ExpressionResolver) -> String? {
    resolver.resolveStringBasedValue(expression: property, initializer: { $0 })
  }

  static let propertyValidator: AnyValueValidator<String> =
    makeStringValidator(minLength: 1)

  init(
    property: Expression<String>? = nil
  ) {
    self.property = property
  }
}

#if DEBUG
extension EntityWithOptionalProperty: Equatable {
  public static func ==(lhs: EntityWithOptionalProperty, rhs: EntityWithOptionalProperty) -> Bool {
    guard
      lhs.property == rhs.property
    else {
      return false
    }
    return true
  }
}
#endif
