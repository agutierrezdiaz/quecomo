package io.github.agutierrezdiaz.quecomo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.agutierrezdiaz.quecomo.models.entity.Ingredient;
import io.github.agutierrezdiaz.quecomo.repositories.IngredientsRepository;

@Service
public class IngredientService {

    @Autowired
    private IngredientsRepository repository;

    public Optional<Ingredient> findById(UUID id) {
        return this.repository.findById(id);
    }

    public List<Ingredient> findAll() {
        return this.repository.findAll();
    }

    public Ingredient save(Ingredient ingredient) {
        return this.repository.save(ingredient);
    }

    public Optional<Ingredient> update(UUID id, Ingredient ingredient) {
        Optional<Ingredient> ingredientOptional = this.repository.findById(id);
        if (ingredientOptional.isPresent()) {
            Ingredient ingredientDb = ingredientOptional.orElseThrow();
            ingredientDb.setName(ingredient.getName());
            ingredientDb.setPicture(ingredient.getPicture());
            ingredientDb.setType(ingredient.getType());
            return Optional.of(this.repository.save(ingredientDb));
        }
        return ingredientOptional;
    }

    public void delete(UUID id) {
        Optional<Ingredient> opt = this.repository.findById(id);
        if (opt.isPresent()) {
            this.repository.delete(opt.get());
        }
    }

    public void delete(Ingredient ingredient) {
        this.repository.delete(ingredient);
    }

}
