package com.seguridadindustrial.backend.test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.seguridadindustrial.backend.test.*;
import com.seguridadindustrial.backend.Incidente;
import com.seguridadindustrial.backend.repository.IncidenteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class IncidenteRepositoryTest {

    @Autowired
    private IncidenteRepository incidenteRepository;

    @Test
    void testFindByEstado() {
        Incidente inc = new Incidente();
        inc.setEstado("Abierto");
        inc.setUsuarioReporta("Pedro");
        incidenteRepository.save(inc);

        List<Incidente> resultado = incidenteRepository.findByEstado("Abierto");
        assertThat(resultado).isNotEmpty();
        assertThat(resultado.get(0).getUsuarioReporta()).isEqualTo("Pedro");
    }

    @Test
    void testFindByUsuarioReporta() {
        Incidente inc = new Incidente();
        inc.setEstado("Cerrado");
        inc.setUsuarioReporta("Lucía");
        incidenteRepository.save(inc);

        List<Incidente> resultado = incidenteRepository.findByUsuarioReporta("Lucía");
        assertThat(resultado).isNotEmpty();
        assertThat(resultado.get(0).getEstado()).isEqualTo("Cerrado");
    }
}
