package io.github.agutierrezdiaz.quecomo.models.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "variants")
public class Variant extends DefaultEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private Dish dish;
    @Column(name = "cooking_time")
    private int cookingTime;

    public Variant() {
    }

    public Variant(Dish dish, int cookingTime) {
        this.dish = dish;
        this.cookingTime = cookingTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            this.id = generateId();
        }
    }

    @Override
    public String toString() {
        return "Variant [id=" + id + ", dish=" + dish + ", cookingTime=" + cookingTime + "]";
    }

}
