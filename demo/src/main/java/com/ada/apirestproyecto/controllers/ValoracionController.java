package com.ada.apirestproyecto.controllers;

import com.ada.apirestproyecto.entities.Valoracion;
import com.ada.apirestproyecto.services.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valoraciones")
public class ValoracionController {

    @Autowired
    private ValoracionService valoracionService;

    @GetMapping
    public List<Valoracion> listar() {
        return valoracionService.findAll();
    }

    @PostMapping
    public Valoracion crear(@RequestBody Valoracion valoracion) {
        return valoracionService.save(valoracion);
    }

    // DELETE con parámetros: localhost:8080/api/valoraciones?idUsuario=1&idRuta=5
    @DeleteMapping
    public void borrar(@RequestParam Long idUsuario, @RequestParam Long idRuta) {
        valoracionService.delete(idUsuario, idRuta);
    }
}
