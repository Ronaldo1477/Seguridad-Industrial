package com.seguridadindustrial.backend.test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.seguridadindustrial.backend.test.*;
import com.seguridadindustrial.backend.Capacitacion;
import com.seguridadindustrial.backend.repository.CapacitacionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CapacitacionRepositoryTest {

    @Autowired
    private CapacitacionRepository capacitacionRepository;

    @Test
    void testFindByArea() {
        Capacitacion cap = new Capacitacion();
        cap.setArea("Seguridad");
        cap.setResponsable("María");
        capacitacionRepository.save(cap);

        List<Capacitacion> resultado = capacitacionRepository.findByArea("Seguridad");
        assertThat(resultado).isNotEmpty();
        assertThat(resultado.get(0).getResponsable()).isEqualTo("María");
    }

    @Test
    void testFindByResponsable() {
        Capacitacion cap = new Capacitacion();
        cap.setArea("Prevención");
        cap.setResponsable("Carlos");
        capacitacionRepository.save(cap);

        List<Capacitacion> resultado = capacitacionRepository.findByResponsable("Carlos");
        assertThat(resultado).isNotEmpty();
        assertThat(resultado.get(0).getArea()).isEqualTo("Prevención");
    }
}

