package com.seguridadindustrial.backend.controller;

import com.seguridadindustrial.backend.Usuario;
import com.seguridadindustrial.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public static class LoginRequest {
        public String usuario;
        public String password;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        Usuario usuario = usuarioRepository.findByUsernameAndPassword(loginRequest.usuario, loginRequest.password);
        
        if (usuario != null) {
            return "{\"success\": true, \"mensaje\": \"Login exitoso\", \"usuario\": \"" + 
                   usuario.getUsername() + "\", \"rol\": \"" + usuario.getRol() + "\"}";
        } else {
            return "{\"success\": false, \"mensaje\": \"Usuario o contraseña incorrectos\"}";
        }
    }

    @GetMapping("/test")
    public String test() {
        return "✅ Backend de Seguridad Industrial funcionando correctamente";
    }
}