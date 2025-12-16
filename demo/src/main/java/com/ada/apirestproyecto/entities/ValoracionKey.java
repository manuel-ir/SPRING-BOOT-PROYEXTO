package com.ada.apirestproyecto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ValoracionKey implements Serializable {

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_ruta")
    private Long idRuta;

    // Constructores
    public ValoracionKey() {}

    public ValoracionKey(Long idUsuario, Long idRuta) {
        this.idUsuario = idUsuario;
        this.idRuta = idRuta;
    }

    // Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Long idRuta) {
        this.idRuta = idRuta;
    }

    // hashCode y equals obligatorios
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValoracionKey that = (ValoracionKey) o;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(idRuta, that.idRuta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idRuta);
    }
}