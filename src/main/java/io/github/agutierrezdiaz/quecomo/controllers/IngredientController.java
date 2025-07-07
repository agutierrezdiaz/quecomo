package io.github.agutierrezdiaz.quecomo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.agutierrezdiaz.quecomo.models.entity.Ingredient;
import io.github.agutierrezdiaz.quecomo.models.entity.IngredientType;
import io.github.agutierrezdiaz.quecomo.services.IngredientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<Ingredient>> getIngredientsList() {
        return ResponseEntity.status(HttpStatus.OK).body(this.ingredientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientByUuid(@PathVariable(value = "id") UUID id) {
        Optional<Ingredient> ingredientOptional = this.ingredientService.findById(id);
        if (ingredientOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(ingredientOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@Valid @RequestBody Ingredient ingredient) {
        if (ingredient.getType() == null) {
            ingredient.setType(IngredientType.GRAINS);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.ingredientService.save(ingredient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable(value = "id") UUID id,
            @Valid @RequestBody Ingredient ingredient) {
        Optional<Ingredient> ingredientOptional = this.ingredientService.update(id, ingredient);
        if (ingredientOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(ingredientOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteIngredient(@PathVariable(value = "id") UUID id) {
        Optional<Ingredient> ingredientOptional = this.ingredientService.findById(id);
        if (ingredientOptional.isPresent()) {
            this.ingredientService.delete(ingredientOptional.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
