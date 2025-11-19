package com.seguridadindustrial.backend.test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import com.seguridadindustrial.backend.test.*;
import com.seguridadindustrial.backend.Usuario;
import com.seguridadindustrial.backend.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testFindByUsernameAndPassword() {
        Usuario user = new Usuario();
        user.setUsername("admin");
        user.setPassword("1234");
        usuarioRepository.save(user);

        Usuario resultado = usuarioRepository.findByUsernameAndPassword("admin", "1234");
        assertThat(resultado).isNotNull();
        assertThat(resultado.getUsername()).isEqualTo("admin");
    }
}
