package com.inversiones.cartera.domain.ports;

import com.inversiones.cartera.domain.model.Cartera;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarteraRepository {
    
    Optional<Cartera> findById(UUID id);
    
    List<Cartera> findAll();
    
    Cartera save(Cartera cartera);
    
    void deleteById(UUID id);
    
    boolean existsById(UUID id);
    
    List<Cartera> findByNombreContainingIgnoreCase(String nombre);
}