package com.seguridadindustrial.backend.controller;

import com.seguridadindustrial.backend.Capacitacion;
import com.seguridadindustrial.backend.repository.CapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/capacitaciones")
@CrossOrigin(origins = "*")
public class CapacitacionController {

    @Autowired
    private CapacitacionRepository capacitacionRepository;

    @GetMapping
    public List<Capacitacion> getAllCapacitaciones() {
        return capacitacionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Capacitacion getCapacitacionById(@PathVariable Long id) {
        return capacitacionRepository.findById(id).orElse(null);
    }

    @GetMapping("/area/{area}")
    public List<Capacitacion> getCapacitacionesByArea(@PathVariable String area) {
        return capacitacionRepository.findByArea(area);
    }

    @PostMapping
    public Capacitacion createCapacitacion(@RequestBody Capacitacion capacitacion) {
        return capacitacionRepository.save(capacitacion);
    }

    @PutMapping("/{id}")
    public Capacitacion updateCapacitacion(@PathVariable Long id, @RequestBody Capacitacion capacitacionDetails) {
        Capacitacion capacitacion = capacitacionRepository.findById(id).orElse(null);
        if (capacitacion != null) {
            if (capacitacionDetails.getTema() != null) {
                capacitacion.setTema(capacitacionDetails.getTema());
            }
            if (capacitacionDetails.getFecha() != null) {
                capacitacion.setFecha(capacitacionDetails.getFecha());
            }
            if (capacitacionDetails.getHora() != null) {
                capacitacion.setHora(capacitacionDetails.getHora());
            }
            if (capacitacionDetails.getDuracion() != null) {
                capacitacion.setDuracion(capacitacionDetails.getDuracion());
            }
            if (capacitacionDetails.getResponsable() != null) {
                capacitacion.setResponsable(capacitacionDetails.getResponsable());
            }
            if (capacitacionDetails.getArea() != null) {
                capacitacion.setArea(capacitacionDetails.getArea());
            }
            return capacitacionRepository.save(capacitacion);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCapacitacion(@PathVariable Long id) {
        capacitacionRepository.deleteById(id);
    }
}
