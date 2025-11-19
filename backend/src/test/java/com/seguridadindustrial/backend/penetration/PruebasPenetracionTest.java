package com.seguridadindustrial.backend.penetration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PruebasPenetracionTest {

    @LocalServerPort
    private int port;

    @Test
    void pruebaSQLInjectionEnIncidentes() {
        RestAssured.baseURI = "http://localhost:" + port;

        // SQL Injection en parámetros de búsqueda
        RestAssured
            .given()
                .param("search", "test' OR '1'='1")
            .when()
                .get("/api/incidentes")
            .then()
                .statusCode(anyOf(equalTo(200), equalTo(400), equalTo(500)))
                .body(not(containsString("error de sintaxis")));
    }

    @Test
    void pruebaXSSEnComentarios() {
        RestAssured.baseURI = "http://localhost:" + port;

        // XSS con campos válidos pero contenido malicioso
        RestAssured
            .given()
                .contentType("application/json")
                .body("""
                    {
                        "asunto": "Test Seguro",
                        "comentario": "Contenido normal <img src=x onerror=alert(1)>",
                        "empleado": "user123",
                        "estado": "PENDIENTE",
                        "fecha": "2023-12-01",
                        "nombre": "Usuario <script>alert('xss')</script>"
                    }
                    """)
            .when()
                .post("/api/comentarios")
            .then()
                .statusCode(anyOf(equalTo(201), equalTo(400), equalTo(500)))
                .body(not(containsString("<script>")));
    }

    @Test
    void pruebaAutenticacionInsegura() {
        RestAssured.baseURI = "http://localhost:" + port;

        // Intentar login sin credenciales
        RestAssured
            .given()
                .contentType("application/json")
                .body("{}")
            .when()
                .post("/api/usuarios/login")
            .then()
                .statusCode(anyOf(equalTo(400), equalTo(401), equalTo(404), equalTo(500)));
    }
}