package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class PostmanEchoTest {
    @Test
    void shouldPostToPostman(){
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("some data"))
        ;

    }
    @Test
    void shouldReturnCurrency(){
        given()
                .baseUri("https://postman-echo.com")
                .body("Currency USD")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("USD", equalTo("Currency:USD"))
        ;

    }
    @Test
    void shouldReturnId(){
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("Id:3"))
                ;
    }

}
