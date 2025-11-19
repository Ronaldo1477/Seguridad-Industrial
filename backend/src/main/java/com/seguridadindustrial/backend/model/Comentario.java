package com.seguridadindustrial.backend;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String asunto;
    
    @Column(columnDefinition = "TEXT")
    private String comentario;
    
    private LocalDate fecha;
    private String estado;
    private String empleado;
    
    // Constructores
    public Comentario() {}
    
    public Comentario(String nombre, String asunto, String comentario, String estado, String empleado) {
        this.nombre = nombre;
        this.asunto = asunto;
        this.comentario = comentario;
        this.estado = estado;
        this.empleado = empleado;
        this.fecha = LocalDate.now();
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }
    
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public String getEmpleado() { return empleado; }
    public void setEmpleado(String empleado) { this.empleado = empleado; }
}