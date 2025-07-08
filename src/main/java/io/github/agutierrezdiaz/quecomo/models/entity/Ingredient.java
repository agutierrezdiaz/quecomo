package io.github.agutierrezdiaz.quecomo.models.entity;

import java.io.Serializable;
import java.util.UUID;

import io.github.agutierrezdiaz.quecomo.models.dto.IngredientDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ingredients")
public class Ingredient extends DefaultEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    @NotEmpty
    private String name;
    @NotNull
    private IngredientType type;
    private String picture;

    public Ingredient() {
    }

    public Ingredient(String name, IngredientType type, String picture) {
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

    public IngredientType getType() {
        return type;
    }

    public void setType(IngredientType type) {
        this.type = type;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            this.id = generateId();
        }
    }

    public IngredientDTO convertToDto() {
        IngredientDTO dto = new IngredientDTO();
        dto.setId(this.getId());
        dto.setName(this.getName());
        dto.setType(this.getType().getValue());
        dto.setPicture(this.getPicture());
        return dto;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ingredient other = (Ingredient) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient [id=" + id + ", name=" + name + ", type=" + type + ", picture=" + picture + "]";
    }

}
