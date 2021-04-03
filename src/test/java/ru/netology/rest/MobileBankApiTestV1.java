package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MobileBankApiTestV1 {

    @Test
    void shouldReturnDemoAccounts(){
        //given-when-then
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                .header("Content-type", "application/json; charset=UTF-8")
                .body("", hasSize(3))
                .body("[0].id", equalTo(1))
                .body("[1].balance", greaterThanOrEqualTo(0))
                .body("every{ it.balance >= 0}", is(true));
    }


}
