package io.github.agutierrezdiaz.quecomo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.agutierrezdiaz.quecomo.models.entity.Recipe;
import io.github.agutierrezdiaz.quecomo.repositories.RecipesRepository;

@Service
public class RecipeService {

    @Autowired
    private RecipesRepository repository;

    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }
    
}
