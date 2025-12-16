package com.ada.apirestproyecto.services;

import com.ada.apirestproyecto.entities.Valoracion;
import com.ada.apirestproyecto.entities.ValoracionKey;
import com.ada.apirestproyecto.repositories.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionService {

    @Autowired
    private ValoracionRepository valoracionRepository;

    public List<Valoracion> findAll() {
        return valoracionRepository.findAll();
    }

    public Valoracion save(Valoracion valoracion) {
        // Al guardar, JPA sincroniza las claves primarias gracias a @MapsId
        return valoracionRepository.save(valoracion);
    }
    
    // Método para borrar usando la clave compuesta
    public void delete(Long idUsuario, Long idRuta) {
        ValoracionKey key = new ValoracionKey(idUsuario, idRuta);
        valoracionRepository.deleteById(key);
    }
}
