package io.github.agutierrezdiaz.quecomo.models.dto;

import java.util.UUID;

import io.github.agutierrezdiaz.quecomo.models.entity.Ingredient;
import io.github.agutierrezdiaz.quecomo.models.entity.IngredientType;
import jakarta.validation.constraints.NotEmpty;

public class IngredientDTO {

    private UUID id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String type;
    private String picture;

    public IngredientDTO() {
    }

    public IngredientDTO(String name, String type, String picture) {
        this.name = name;
        this.type = type;
        this.picture = picture;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Ingredient toEntity() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(this.getId());
        ingredient.setName(this.getName());
        ingredient.setType(IngredientType.getTypeByValue(this.getType()));
        ingredient.setPicture(this.getPicture());
        return ingredient;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IngredientDTO other = (IngredientDTO) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "IngredientDTO [id=" + id + ", name=" + name + ", type=" + type + ", picture=" + picture + "]";
    }

}
