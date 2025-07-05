package io.github.agutierrezdiaz.quecomo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.agutierrezdiaz.quecomo.models.entity.Dish;
import io.github.agutierrezdiaz.quecomo.repositories.DishesRepository;

@Service
public class DishService {

    @Autowired
    private DishesRepository repository;

    public List<Dish> getAllDishes() {
        return repository.findAll();
    }
    
}
