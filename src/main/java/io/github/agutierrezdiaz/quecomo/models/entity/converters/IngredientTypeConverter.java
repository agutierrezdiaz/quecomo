package io.github.agutierrezdiaz.quecomo.models.entity.converters;

import io.github.agutierrezdiaz.quecomo.models.entity.IngredientType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class IngredientTypeConverter implements AttributeConverter<IngredientType, String> {

    @Override
    public String convertToDatabaseColumn(IngredientType attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public IngredientType convertToEntityAttribute(String dbData) {
        return dbData != null ? IngredientType.getTypeByValue(dbData) : null;
    }

}
