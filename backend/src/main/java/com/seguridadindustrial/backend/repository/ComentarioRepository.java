package com.seguridadindustrial.backend.repository;

import com.seguridadindustrial.backend.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    // Encuentra comentarios por estado
    List<Comentario> findByEstado(String estado);
    
    // Encuentra comentarios por empleado
    List<Comentario> findByEmpleado(String empleado);
}