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

    // GET
    @GetMapping
    public List<Ruta> listar() {
        return rutaService.findAll();
    }

    // GET
    @GetMapping("/{id}")
    public Optional<Ruta> obtenerUno(@PathVariable Long id) {
        return rutaService.findById(id);
    }

    // POST
    @PostMapping
    public Ruta crear(@RequestBody Ruta ruta) {
        return rutaService.save(ruta);
    }

    // PUT
    @PutMapping("/{id}")
    public Ruta actualizar(@RequestBody Ruta rutaNueva, @PathVariable Long id) {
        Optional<Ruta> opcional = rutaService.findById(id);

        if (opcional.isPresent()) {
            Ruta rutaExistente = opcional.get();

            // Actualizamos los datos
            rutaExistente.setNombre(rutaNueva.getNombre());
            rutaExistente.setDescripcion(rutaNueva.getDescripcion());
            rutaExistente.setUbicacion(rutaNueva.getUbicacion());
            rutaExistente.setDificultad(rutaNueva.getDificultad());
            rutaExistente.setLongitud(rutaNueva.getLongitud());
            rutaExistente.setTipoActividad(rutaNueva.getTipoActividad());
            
            
            return rutaService.save(rutaExistente);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        rutaService.deleteById(id);
    }
}