# entity_with_array_of_nested_items
Описания пока нет.

## JSON
```json
{
  type*: "entity_with_array_of_nested_items",
  items*: [
    {
      entity*: entity,
      property*: "string"
    },
    ...
  ]
}
```

## Параметры
| Параметры | Описание |
| --- | --- |
| `items` | <p>**array**</p><p>Обязательный параметр.</p><p>Массив должен быть непустым.</p> |
| `type` | <p>**string**</p><p>Обязательный параметр.</p><p>Значение всегда должно равняться `entity_with_array_of_nested_items`.</p> |

### item
| Параметры | Описание |
| --- | --- |
| `entity` | <p>**object**</p><p>Обязательный параметр.</p><p>Значение имеет тип `entity`.</p><p>Список возможных значений:<li>[entity_with_array](entity_with_array.md#entity_with_array)</li><li>[entity_with_array_of_enums](entity_with_array_of_enums.md#entity_with_array_of_enums)</li><li>[entity_with_array_of_expressions](entity_with_array_of_expressions.md#entity_with_array_of_expressions)</li><li>[entity_with_array_of_nested_items](entity_with_array_of_nested_items.md#entity_with_array_of_nested_items)</li><li>[entity_with_array_with_transform](entity_with_array_with_transform.md#entity_with_array_with_transform)</li><li>[entity_with_complex_property](entity_with_complex_property.md#entity_with_complex_property)</li><li>[entity_with_complex_property_with_default_value](entity_with_complex_property_with_default_value.md#entity_with_complex_property_with_default_value)</li><li>[entity_with_entity_property](entity_with_entity_property.md#entity_with_entity_property)</li><li>[entity_with_optional_complex_property](entity_with_optional_complex_property.md#entity_with_optional_complex_property)</li><li>[entity_with_optional_property](entity_with_optional_property.md#entity_with_optional_property)</li><li>[entity_with_optional_string_enum_property](entity_with_optional_string_enum_property.md#entity_with_optional_string_enum_property)</li><li>[entity_with_property_with_default_value](entity_with_property_with_default_value.md#entity_with_property_with_default_value)</li><li>[entity_with_raw_array](entity_with_raw_array.md#entity_with_raw_array)</li><li>[entity_with_required_property](entity_with_required_property.md#entity_with_required_property)</li><li>[entity_with_simple_properties](entity_with_simple_properties.md#entity_with_simple_properties)</li><li>[entity_with_strict_array](entity_with_strict_array.md#entity_with_strict_array)</li><li>[entity_with_string_array_property](entity_with_string_array_property.md#entity_with_string_array_property)</li><li>[entity_with_string_enum_property](entity_with_string_enum_property.md#entity_with_string_enum_property)</li><li>[entity_with_string_enum_property_with_default_value](entity_with_string_enum_property_with_default_value.md#entity_with_string_enum_property_with_default_value)</li><li>[entity_without_properties](entity_without_properties.md#entity_without_properties)</li></p> |
| `property` | <p>**string**</p><p>Обязательный параметр.</p><p>Строка должна быть непустой.</p> |
