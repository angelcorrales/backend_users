package com.bbva.play;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UserRsourceTest {

    @Test
    public void testUserResource() {
       given()
            .when().get("/user")
            .then()
            .statusCode(200);
    }

    @Test
    public void testGreetingEndpoint() {
        /*
        String uuid = UUID.randomUUID().toString();
        given()
                .pathParam("name", uuid)
                .when().get("/hello/greeting/{name}")
                .then()
                .statusCode(200)
                .body(is("hello " + uuid));*/
    }

}
