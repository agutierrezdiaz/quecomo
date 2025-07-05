package io.github.agutierrezdiaz.quecomo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.agutierrezdiaz.quecomo.models.entity.Dish;

@Repository
public interface DishesRepository extends JpaRepository<Dish, UUID> {

}
