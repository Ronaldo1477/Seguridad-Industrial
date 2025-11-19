/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seguridadindustrial.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConexionController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/conexion")
    public String verificarConexion() {
        try {
            String version = jdbcTemplate.queryForObject("SELECT version()", String.class);
            return "✅ Conexión exitosa a Supabase.\nVersión del servidor: " + version;
        } catch (Exception e) {
            return "❌ Error al conectar con la base de datos: " + e.getMessage();
        }
    }
}
