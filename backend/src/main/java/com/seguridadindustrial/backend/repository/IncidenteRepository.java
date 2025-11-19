package com.seguridadindustrial.backend.repository;

import com.seguridadindustrial.backend.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IncidenteRepository extends JpaRepository<Incidente, Long> {
    // Encuentra incidentes por estado
    List<Incidente> findByEstado(String estado);
    
    // Encuentra incidentes por usuario que reportó
    List<Incidente> findByUsuarioReporta(String usuarioReporta);
}
