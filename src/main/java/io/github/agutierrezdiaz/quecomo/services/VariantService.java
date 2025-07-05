package io.github.agutierrezdiaz.quecomo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.agutierrezdiaz.quecomo.models.entity.Variant;
import io.github.agutierrezdiaz.quecomo.repositories.VariantsRepository;

@Service
public class VariantService {

    @Autowired
    private VariantsRepository repository;

    public List<Variant> getallVariants() {
        return repository.findAll();
    }
    
}
