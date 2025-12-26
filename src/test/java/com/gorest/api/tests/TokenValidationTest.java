package com.gorest.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import com.gorest.api.utilities.ConfigReader;
import com.gorest.api.utilities.TokenUtil;

public class TokenValidationTest {

    @Test
    public void validateToken() {

        Response response =
                given()
                    .baseUri(ConfigReader.get("base.url"))
                    .header("Authorization", TokenUtil.getToken())
                .when()
                    .get("/users");

        Assert.assertTrue(
            response.getStatusCode() == 200 ||
            response.getStatusCode() == 401,
            "Unexpected status code"
        );

        Assert.assertEquals(response.getStatusCode(), 200,
                "Invalid or expired token");
    }
}
