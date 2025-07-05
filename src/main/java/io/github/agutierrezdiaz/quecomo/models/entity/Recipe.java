package io.github.agutierrezdiaz.quecomo.models.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "recipes")
public class Recipe extends DefaultEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    private Variant variant;
    private Ingredient ingredient;
    private String quantity;
    private boolean required;

    public Recipe() {
    }

    public Recipe(Variant variant, Ingredient ingredient, String quantity, boolean required) {
        this.variant = variant;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.required = required;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            this.id = generateId();
        }
    }

}
