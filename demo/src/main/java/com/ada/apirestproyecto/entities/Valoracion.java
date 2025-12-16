package com.ada.apirestproyecto.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VALORACION")
public class Valoracion {

    @EmbeddedId
    private ValoracionKey id = new ValoracionKey();

    // Relaciones
    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("idRuta")
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;

    @Column(nullable = false)
    private Integer puntuacion;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    @Column(name = "fecha_valoracion")
    private LocalDateTime fechaValoracion = LocalDateTime.now();

    // Constructores
    public Valoracion() {}

    public Valoracion(Usuario usuario, Ruta ruta, Integer puntuacion, String comentario) {
        this.usuario = usuario;
        this.ruta = ruta;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fechaValoracion = LocalDateTime.now();
        this.id = new ValoracionKey(usuario.getId(), ruta.getId());
    }

    // Getters y Setters
    public ValoracionKey getId() {
        return id;
    }

    public void setId(ValoracionKey id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(LocalDateTime fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }
}