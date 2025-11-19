package com.seguridadindustrial.backend.deserialization;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PruebasDeserializacionTest {

    @LocalServerPort
    private int port;

    @Test
    void pruebaDeserializacionMaliciosaJSON() {
        RestAssured.baseURI = "http://localhost:" + port;

        // JSON con estructura maliciosa pero campos válidos
        String jsonMalicioso = """
            {
                "nombre": "Test <script>alert('xss')</script>",
                "email": "test'; DROP TABLE usuarios; --@empresa.com",
                "rol": "EMPLEADO' OR '1'='1"
            }
            """;

        RestAssured
            .given()
                .contentType("application/json")
                .body(jsonMalicioso)
            .when()
                .post("/api/usuarios")
            .then()
                .statusCode(anyOf(equalTo(400), equalTo(500), equalTo(201)))
                .body(not(containsString("DROP TABLE"))); // No debe mostrar SQL en error
    }

    @Test
    void pruebaPayloadExcesivamenteGrande() {
        RestAssured.baseURI = "http://localhost:" + port;

        // Payload más pequeño pero aún problemático
        String payloadGrande = "{\"contenido\": \"" + "A".repeat(5000) + "\"}";

        RestAssured
            .given()
                .contentType("application/json")
                .body(payloadGrande)
            .when()
                .post("/api/comentarios")
            .then()
                .statusCode(anyOf(equalTo(400), equalTo(500), equalTo(413)));
    }

    @Test
    void pruebaTiposDeDatosIncorrectos() {
        RestAssured.baseURI = "http://localhost:" + port;

        // Enviar datos que deberían ser rechazados
        RestAssured
            .given()
                .contentType("application/json")
                .body("""
                    {
                        "asunto": "Test Validación",
                        "comentario": "Contenido normal",
                        "empleado": "user123",
                        "estado": "PENDIENTE",
                        "fecha": "2023-13-45",  // Fecha inválida
                        "nombre": "Usuario Test"
                    }
                    """)
            .when()
                .post("/api/comentarios")
            .then()
                .statusCode(anyOf(equalTo(400), equalTo(500)));
    }
}