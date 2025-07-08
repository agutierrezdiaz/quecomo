package io.github.agutierrezdiaz.quecomo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.agutierrezdiaz.quecomo.models.dto.IngredientDTO;
import io.github.agutierrezdiaz.quecomo.models.entity.Ingredient;
import io.github.agutierrezdiaz.quecomo.repositories.IngredientsRepository;

@Service
public class IngredientService {

    @Autowired
    private IngredientsRepository repository;

    public Optional<IngredientDTO> findById(UUID id) {
        return Optional.of(this.repository.findById(id).orElseThrow().convertToDto());
    }

    public List<IngredientDTO> findAll() {
        return this.repository.findAll().stream().map(Ingredient::convertToDto).collect(Collectors.toList());
    }

    public IngredientDTO save(IngredientDTO ingredientDto) {
        return this.repository.save(ingredientDto.toEntity()).convertToDto();
    }

    public Optional<IngredientDTO> update(UUID id, IngredientDTO ingredientDto) {
        Optional<IngredientDTO> ingredientOptional = Optional
                .of(this.repository.findById(id).orElseThrow().convertToDto());
        if (ingredientOptional.isPresent()) {
            IngredientDTO ingredientDb = ingredientOptional.get();
            ingredientDb.setName(ingredientDto.getName());
            ingredientDb.setPicture(ingredientDto.getPicture());
            ingredientDb.setType(ingredientDto.getType());
            return Optional.of(this.repository.save(ingredientDb.toEntity()).convertToDto());
        }
        return ingredientOptional;
    }

    public void delete(UUID id) {
        Optional<Ingredient> opt = this.repository.findById(id);
        if (opt.isPresent()) {
            this.repository.delete(opt.get());
        }
    }

    public void delete(IngredientDTO ingredientDto) {
        this.repository.delete(ingredientDto.toEntity());
    }

}
