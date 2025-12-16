package com.ada.apirestproyecto.controllers;

import com.ada.apirestproyecto.entities.Ruta;
import com.ada.apirestproyecto.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rutas")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @GetMapping
    public List<Ruta> listar() {
        return rutaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ruta> obtenerUno(@PathVariable Long id) {
        return rutaService.findById(id);
    }

    @PostMapping
    public Ruta crear(@RequestBody Ruta ruta) {
        return rutaService.save(ruta);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        rutaService.deleteById(id);
    }
}
