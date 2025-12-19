package com.ada.apirestproyecto.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "RUTA")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta")
    private Long id;

    @Column(name = "nombre_ruta", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion_ruta", columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, length = 100)
    private String ubicacion;

    @Column(length = 20)
    private String dificultad;

    @Column(name = "tipo_actividad", length = 50)
    private String tipoActividad;

    private BigDecimal longitud;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // RELACIONES

    // Hija de Usuario
    @ManyToOne
    @JoinColumn(name = "id_creador", nullable = false)
    @JsonBackReference(value = "usuario-rutas") 
    private Usuario creador;

    // Madre de Valoraciones
    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "ruta-valoraciones") 
    private List<Valoracion> valoraciones;

    // Constructores
    public Ruta() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public List<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(List<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }
}