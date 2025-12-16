package com.ada.apirestproyecto.controllers;

import com.ada.apirestproyecto.entities.Usuario;
import com.ada.apirestproyecto.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET localhost:8080/api/usuarios
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.findAll();
    }

    // GET localhost:8080/api/usuarios/1
    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUno(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    // POST localhost:8080/api/usuarios
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    // DELETE localhost:8080/api/usuarios/1
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}
