package io.github.agutierrezdiaz.quecomo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.agutierrezdiaz.quecomo.models.entity.Ingredient;
import io.github.agutierrezdiaz.quecomo.repositories.IngredientsRepository;

@Service
public class IngredientService {

    @Autowired
    private IngredientsRepository repository;

    public List<Ingredient> getAllIngredients() {
        return repository.findAll();
    }

}
