package com.seguridadindustrial.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {

    @GetMapping("/testhome")
    public String testHome() {
        return "✅ HomeController activo";
    }
    
    @GetMapping("/test")
    public String test() {
        return "✅ Test endpoint funcionando";
    }

    // Nuevo endpoint raíz para que no te de error 404 en "/"
    @GetMapping("/")
    public String home() {
        return "✅ Backend de Seguridad Industrial está funcionando en puerto 8081";
    }

    // Endpoint health para verificar estado del backend
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}