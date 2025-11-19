package com.seguridadindustrial.backend.controller;

import com.seguridadindustrial.backend.Incidente;
import com.seguridadindustrial.backend.repository.IncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/incidentes")
@CrossOrigin(origins = "*")
public class IncidenteController {

    @Autowired
    private IncidenteRepository incidenteRepository;

    @GetMapping
    public List<Incidente> getAllIncidentes() {
        return incidenteRepository.findAll();
    }

    @GetMapping("/estado/{estado}")
    public List<Incidente> getIncidentesByEstado(@PathVariable String estado) {
        return incidenteRepository.findByEstado(estado);
    }
    
    @GetMapping("/{id}")
    public Incidente getIncidenteById(@PathVariable Long id) {
        return incidenteRepository.findById(id).orElse(null);
    }


    @PostMapping
    public Incidente createIncidente(@RequestBody Incidente incidente) {
        return incidenteRepository.save(incidente);
    }

    @PutMapping("/{id}")
    public Incidente updateIncidente(@PathVariable Long id, @RequestBody Incidente incidenteDetails) {
        Incidente incidente = incidenteRepository.findById(id).orElse(null);
        if (incidente != null) {
            // Actualizar solo los campos necesarios
            if (incidenteDetails.getTipoIncidencia() != null) {
                incidente.setTipoIncidencia(incidenteDetails.getTipoIncidencia());
            }
            if (incidenteDetails.getFechaHora() != null) {
                incidente.setFechaHora(incidenteDetails.getFechaHora());
            }
            if (incidenteDetails.getUbicacion() != null) {
                incidente.setUbicacion(incidenteDetails.getUbicacion());
            }
            if (incidenteDetails.getDescripcion() != null) {
                incidente.setDescripcion(incidenteDetails.getDescripcion());
            }
            if (incidenteDetails.getAccion() != null) {
                incidente.setAccion(incidenteDetails.getAccion());
            }
            if (incidenteDetails.getEstado() != null) {
                incidente.setEstado(incidenteDetails.getEstado());
            }
            if (incidenteDetails.getUsuarioReporta() != null) {
                incidente.setUsuarioReporta(incidenteDetails.getUsuarioReporta());
            }
            return incidenteRepository.save(incidente);
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public void deleteIncidente(@PathVariable Long id) {
        incidenteRepository.deleteById(id);
    }
}
