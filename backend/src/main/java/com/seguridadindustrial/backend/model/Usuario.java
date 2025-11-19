package com.seguridadindustrial.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    private String username;
    
    private String password;
    private String rol;
    private String nombreCompleto;
    private String email;
    private String areaTrabajo;
    
    // Constructores
    public Usuario() {}
    
    public Usuario(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
    
    // Getters y Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    
    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getAreaTrabajo() { return areaTrabajo; }
    public void setAreaTrabajo(String areaTrabajo) { this.areaTrabajo = areaTrabajo; }
}
