package com.seguridadindustrial.backend.repository;

import com.seguridadindustrial.backend.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    // Encuentra usuario por username y password (para login)
    Usuario findByUsernameAndPassword(String username, String password);
}
