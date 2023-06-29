package org.example;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

public class PetStoreAPI {

    // Number 1
    @ParameterizedTest
    @ValueSource(ints = {1,5,10})
        public void simpleParamPositiveTestGet(int orderId){
        given()
                .when()
                .log()
                .all()
                .get("https://petstore.swagger.io/v2/store/order/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);

    }

    // Number 2
    @ParameterizedTest
    @ValueSource (ints = {0,11})
        public void simpleParamNegativeTestGet(int orderId){
        given()
                .when()
                .log()
                .all()
                .get("https://petstore.swagger.io/v2/store/order/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    // Number 4
    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    public void simplePositiveTestResponseBodyStatusPlacedGet(int orderId){
      String status = given()
                .when()
                .log()
                .all()
                .get("https://petstore.swagger.io/v2/store/order/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("status");

        Assertions.assertEquals("placed", status);
    }

    // Number 5
    @ParameterizedTest
    @ValueSource (ints = {3,6,9})
        public void simplePositiveTestResponseBodyStatusApprovedGet(int orderId){
            String status = given()
                    .when()
                    .log()
                    .all()
                    .get("https://petstore.swagger.io/v2/store/order/{orderId}", orderId)
                    .then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK)
                    .and()
                    .extract()
                    .path("status");

            Assertions.assertEquals("approved", status);

        }

        // Number 6
    @ParameterizedTest
    @ValueSource (ints ={3,6,9})
    public void simplePositiveTestResponseBodyStatusDeliveredGet(int orderId){
        String status = given()
                .when()
                .log()
                .all()
                .get("https://petstore.swagger.io/v2/store/order/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("status");

        Assertions.assertEquals("delivered", status);
    }

    // Number 7
    @Test
    public void simplePositiveTestResponseBodyCompleteTrueGet(){
        Boolean complete = given()
                .when()
                .log()
                .all()
                .get("https://petstore.swagger.io/v2/store/order/6")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("complete");

        Assertions.assertEquals( true, complete);
    }

    // Number 8
    @ParameterizedTest
    @ValueSource(ints = {1,3,6,8,9})
    public void simplePositiveTestResponseBodyCompleteFalseGet(int orderId){
        Boolean complete = given()
                .when()
                .log()
                .all()
                .get("https://petstore.swagger.io/v2/store/order/{orderId}", orderId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .extract()
                .path("complete");

        Assertions.assertEquals(false,complete);

    }
}

