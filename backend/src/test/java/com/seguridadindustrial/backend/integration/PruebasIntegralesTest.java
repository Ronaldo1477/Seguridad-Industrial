package com.seguridadindustrial.backend.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PruebasIntegralesTest {

    @LocalServerPort
    private int port;

    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
        .withDatabaseName("testdb")
        .withUsername("test")
        .withPassword("test");

    @Test
    void pruebaIntegracionCompleta_UsuarioYIncidente() {
        RestAssured.baseURI = "http://localhost:" + port;

        // Crear usuario
        String usuarioId = RestAssured
            .given()
                .contentType("application/json")
                .body("""
                    {
                        "nombre": "Usuario Test",
                        "email": "test@empresa.com",
                        "rol": "EMPLEADO"
                    }
                    """)
            .when()
                .post("/api/usuarios")
            .then()
                .statusCode(201)
                .body("id", notNullValue())
                .extract().path("id");

        // Crear incidente asociado al usuario
        RestAssured
            .given()
                .contentType("application/json")
                .body("""
                    {
                        "titulo": "Incidente Test Integral",
                        "descripcion": "Descripción del incidente",
                        "severidad": "MEDIA",
                        "usuarioId": "%s"
                    }
                    """.formatted(usuarioId))
            .when()
                .post("/api/incidentes")
            .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("titulo", equalTo("Incidente Test Integral"));
    }
}