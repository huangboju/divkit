// Generated code. Do not modify.

import 'package:equatable/equatable.dart';

import '../utils/parsing_extensions.dart';
import 'entity.dart';
import 'entity_with_string_enum_property.dart';

class EntityWithEntityProperty with EquatableMixin {
  const EntityWithEntityProperty({
    this.entity = const Entity.entityWithStringEnumProperty(const EntityWithStringEnumProperty(property: EntityWithStringEnumPropertyProperty.second,)),
  });

  static const type = "entity_with_entity_property";
  // default value: const Entity.entityWithStringEnumProperty(const EntityWithStringEnumProperty(property: EntityWithStringEnumPropertyProperty.second,))
  final Entity entity;

  @override
  List<Object?> get props => [
        entity,
      ];

  static EntityWithEntityProperty? fromJson(Map<String, dynamic>? json) {
    if (json == null) {
      return null;
    }
    return EntityWithEntityProperty(
      entity: Entity.fromJson(json['entity']) ?? const Entity.entityWithStringEnumProperty(const EntityWithStringEnumProperty(property: EntityWithStringEnumPropertyProperty.second,)),
    );
  }
}
