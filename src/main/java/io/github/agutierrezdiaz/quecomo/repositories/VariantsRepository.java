package io.github.agutierrezdiaz.quecomo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.agutierrezdiaz.quecomo.models.entity.Variant;

@Repository
public interface VariantsRepository extends JpaRepository<Variant, UUID> {
    
}
