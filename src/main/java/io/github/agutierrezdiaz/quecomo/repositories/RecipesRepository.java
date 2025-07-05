package io.github.agutierrezdiaz.quecomo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.agutierrezdiaz.quecomo.models.entity.Recipe;

@Repository
public interface RecipesRepository extends JpaRepository<Recipe, UUID> {
    
}
