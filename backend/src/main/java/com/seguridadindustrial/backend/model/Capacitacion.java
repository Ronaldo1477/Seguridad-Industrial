package com.seguridadindustrial.backend;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "capacitaciones")
public class Capacitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tema;
    private LocalDate fecha;
    private LocalTime hora;
    private Integer duracion;
    private String responsable;
    private String area;
    
    // Constructores
    public Capacitacion() {}
    
    public Capacitacion(String tema, LocalDate fecha, LocalTime hora, String responsable, String area) {
        this.tema = tema;
        this.fecha = fecha;
        this.hora = hora;
        this.responsable = responsable;
        this.area = area;
        this.duracion = 2; // valor por defecto
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }
    
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    
    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }
    
    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
    
    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }
}
