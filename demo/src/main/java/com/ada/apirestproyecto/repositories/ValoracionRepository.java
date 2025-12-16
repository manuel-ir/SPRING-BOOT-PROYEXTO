package com.ada.apirestproyecto.repositories;

import com.ada.apirestproyecto.entities.Valoracion;
import com.ada.apirestproyecto.entities.ValoracionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, ValoracionKey> {
    
}
