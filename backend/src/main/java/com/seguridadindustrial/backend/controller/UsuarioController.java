package com.seguridadindustrial.backend.controller;

import com.seguridadindustrial.backend.Usuario;
import com.seguridadindustrial.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{username}")
    public Usuario getUsuario(@PathVariable String username) {
        return usuarioRepository.findById(username).orElse(null);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{username}")
    public Usuario updateUsuario(@PathVariable String username, @RequestBody Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(username).orElse(null);
        if (usuario != null) {
            usuario.setPassword(usuarioDetails.getPassword());
            usuario.setRol(usuarioDetails.getRol());
            usuario.setNombreCompleto(usuarioDetails.getNombreCompleto());
            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setAreaTrabajo(usuarioDetails.getAreaTrabajo());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @DeleteMapping("/{username}")
    public void deleteUsuario(@PathVariable String username) {
        usuarioRepository.deleteById(username);
    }
}
