package com.seguridadindustrial.backend.controller;

import com.seguridadindustrial.backend.Comentario;
import com.seguridadindustrial.backend.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@CrossOrigin(origins = "*")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @GetMapping
    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    @GetMapping("/estado/{estado}")
    public List<Comentario> getComentariosByEstado(@PathVariable String estado) {
        return comentarioRepository.findByEstado(estado);
    }

    @PostMapping
    public Comentario createComentario(@RequestBody Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @PutMapping("/{id}/atendido")
    public Comentario marcarComoAtendido(@PathVariable Long id) {
        Comentario comentario = comentarioRepository.findById(id).orElse(null);
        if (comentario != null) {
            comentario.setEstado("atendido");
            return comentarioRepository.save(comentario);
        }
        return null;
    }

    @PutMapping("/{id}")
    public Comentario updateComentario(@PathVariable Long id, @RequestBody Comentario comentarioDetails) {
        Comentario comentario = comentarioRepository.findById(id).orElse(null);
        if (comentario != null) {
            comentario.setNombre(comentarioDetails.getNombre());
            comentario.setAsunto(comentarioDetails.getAsunto());
            comentario.setComentario(comentarioDetails.getComentario());
            comentario.setEstado(comentarioDetails.getEstado());
            comentario.setEmpleado(comentarioDetails.getEmpleado());
            return comentarioRepository.save(comentario);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteComentario(@PathVariable Long id) {
        comentarioRepository.deleteById(id);
    }
}
