package io.github.agutierrezdiaz.quecomo.models.entity;

public enum IngredientType {
    MEAT("meat"),
    FISH("fish"),
    EGGS("eggs"),
    DAIRY("dairy"),
    FRUITS("fruits"),
    VEGETABLES("vegetables"),
    GRAINS("grains"),
    LEGUMES("legumes"),
    NUTS("nuts"),
    SEEDS("seeds"),
    SPICES("spices"),
    HERBS("herbs"),
    CONDIMENTS("condiments"),
    OTHER("other");

    private final String value;

    IngredientType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static IngredientType getTypeByValue(String value) {
        for (IngredientType type : values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("IngredientType not found: " + value);
    }

}
