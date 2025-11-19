package com.seguridadindustrial.backend.repository;

import com.seguridadindustrial.backend.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CapacitacionRepository extends JpaRepository<Capacitacion, Long> {
    // Encuentra capacitaciones por área
    List<Capacitacion> findByArea(String area);
    
    // Encuentra capacitaciones por responsable
    List<Capacitacion> findByResponsable(String responsable);
}
