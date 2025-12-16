package com.ada.apirestproyecto.services;

import com.ada.apirestproyecto.entities.Usuario;
import com.ada.apirestproyecto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtiene todos los usuarios
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // Obtiene un usuario por ID
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Guarda o actualizar un usuario
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Borra un usuario por ID
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
