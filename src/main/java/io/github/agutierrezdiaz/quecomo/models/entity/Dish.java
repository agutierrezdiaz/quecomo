package io.github.agutierrezdiaz.quecomo.models.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "dishes")
public class Dish extends DefaultEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    @NotEmpty
    private String name;
    private String picture;

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Variant> variants;

    public Dish() {
    }

    public Dish(String name, String picture) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Dish [id=" + id + ", name=" + name + ", picture=" + picture + "]";
    }

}
