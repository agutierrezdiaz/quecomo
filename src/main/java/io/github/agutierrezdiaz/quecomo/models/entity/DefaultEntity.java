package io.github.agutierrezdiaz.quecomo.models.entity;

import java.util.UUID;

import com.github.f4b6a3.uuid.UuidCreator;

/**
 * Default class for shared functionalities between entities
 */
public class DefaultEntity {

    /**
     * Generates a sequential uuid using UUIDv6
     * 
     * It can be changed to UUIDv1:
     * UuidCreator.getTimeBased();
     * 
     * @return UUID
     */
    public UUID generateId() {
        return UuidCreator.getTimeOrdered();
    }
    
}
