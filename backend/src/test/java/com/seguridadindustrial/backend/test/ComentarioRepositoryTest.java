package com.seguridadindustrial.backend.test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.seguridadindustrial.backend.test.*;
import com.seguridadindustrial.backend.Comentario;
import com.seguridadindustrial.backend.repository.ComentarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ComentarioRepositoryTest {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Test
    void testFindByEstado() {
        Comentario com = new Comentario();
        com.setEstado("Pendiente");
        com.setEmpleado("Luis");
        comentarioRepository.save(com);

        List<Comentario> resultado = comentarioRepository.findByEstado("Pendiente");
        assertThat(resultado).isNotEmpty();
        assertThat(resultado.get(0).getEmpleado()).isEqualTo("Luis");
    }

    @Test
    void testFindByEmpleado() {
        Comentario com = new Comentario();
        com.setEstado("Aprobado");
        com.setEmpleado("Ana");
        comentarioRepository.save(com);

        List<Comentario> resultado = comentarioRepository.findByEmpleado("Ana");
        assertThat(resultado).isNotEmpty();
        assertThat(resultado.get(0).getEstado()).isEqualTo("Aprobado");
    }
}
