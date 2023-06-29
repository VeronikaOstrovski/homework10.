package org.example;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

/**
 * Unit test for simple App.
 */
public class ApiTest {

    // Number 1
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    public void simpleParamPositiveTestGet(int id) {
        given()
                .when()
                .log()
                .all()
                .get("http://51.250.6.164:8080/test-orders/{id}", id)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }
     // Number 2
    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    public void simpleParamNegativeTestGet(int id) {
        given()
                .when()
                .log()
                .all()
                .get("http://51.250.6.164:8080/test-orders/{id}", id)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    // Number 3
    String requestBody = "{\n" +
            "  \"status\": \"INPROGRESS\",\n" +
            "  \"courierId\": 12,\n" +
            "  \"customerName\": \"string\",\n" +
            "  \"customerPhone\": \"string\",\n" +
            "  \"comment\": \"string\",\n" +
            "  \"id\": 0\n" +
            "}";

    @Test
    public void simplePositiveTestPost() {
        given()
                .when()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .log()
                .all()
                .post("http://51.250.6.164:8080/test-orders")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);

    }

    // Number 4
    String requestBody415 = "{\n" +
            "  \"status\": \"DELIVERED\",\n" +
            "  \"courierId\": 16,\n" +
            "  \"customerName\": \"string\",\n" +
            "  \"customerPhone\": \"string\",\n" +
            "  \"comment\": \"string\",\n" +
            "  \"id\": 0\n" +
            "}";

    @Test
    public void simpleNegativeTestPost() {
        given()
                .when()
                // .header("Content-Type", "application/json")
                .body(requestBody415)
                .log()
                .all()
                .post("http://51.250.6.164:8080/test-orders")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE);
    }

    // Number 5
    @Test
    public void simplePositiveTestResponseBodyStatusOpenGet() {

        String status = given()
                .when()
                .log()
                .all()
                .get("http://51.250.6.164:8080/test-orders/7")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("status");

        Assertions.assertEquals("OPEN", status);

    }

}


