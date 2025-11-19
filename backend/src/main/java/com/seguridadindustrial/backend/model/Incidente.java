package com.seguridadindustrial.backend;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "incidentes")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tipoIncidencia;
    private LocalDateTime fechaHora;
    private String ubicacion;
    private String descripcion;
    private String accion;
    private String estado;
    private String usuarioReporta;
    
    // Constructores
    public Incidente() {}
    
    public Incidente(String tipoIncidencia, LocalDateTime fechaHora, String ubicacion, 
                    String descripcion, String estado, String usuarioReporta) {
        this.tipoIncidencia = tipoIncidencia;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuarioReporta = usuarioReporta;
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTipoIncidencia() { return tipoIncidencia; }
    public void setTipoIncidencia(String tipoIncidencia) { this.tipoIncidencia = tipoIncidencia; }
    
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public String getUsuarioReporta() { return usuarioReporta; }
    public void setUsuarioReporta(String usuarioReporta) { this.usuarioReporta = usuarioReporta; }
}
