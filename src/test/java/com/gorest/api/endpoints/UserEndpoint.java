package com.gorest.api.endpoints;

import static io.restassured.RestAssured.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.gorest.api.payload.UserPayload;
import com.gorest.api.utilities.ExtentTestListener;
import com.gorest.api.utilities.MaskUtil;
import com.gorest.api.utilities.TokenUtil;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoint {

    private static final Logger logger =
            LogManager.getLogger(UserEndpoint.class);

    // ================= CREATE USER =================
    public static Response createUser(UserPayload payload) {

        ExtentTest test = ExtentTestListener.getTest();
        if (test != null) {
            test.info("Creating user");
        } // ✅ MISSING BRACE FIXED HERE

        logger.info("Using token: " +
                MaskUtil.maskToken(TokenUtil.getToken()));

        logger.info("Creating user with email: " + payload.getEmail());

        Response response =
            given()
                .baseUri(Routes.base_url)
                .header("Authorization", TokenUtil.getToken())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                
            .when()
                .post(Routes.create_user);

        logger.info("Create User Response Status: " + response.getStatusCode());

        return response;
    }

    // ================= GET USER =================
    public static Response getUser(int userId) {

        logger.info("Using token: " +
                MaskUtil.maskToken(TokenUtil.getToken()));

        logger.info("Fetching user with ID: " + userId);

        Response response =
            given()
                .baseUri(Routes.base_url)
                .header("Authorization", TokenUtil.getToken())
                .pathParam("id", userId)
            .when()
                .get(Routes.get_user);

        logger.info("Get User Response Status: " + response.getStatusCode());

        return response;
    }

    // ================= UPDATE USER =================
    public static Response updateUser(int userId, UserPayload payload) {

        logger.info("Using token: " +
                MaskUtil.maskToken(TokenUtil.getToken()));

        logger.info("Updating user with email: " + payload.getEmail());

        Response response =
            given()
                .baseUri(Routes.base_url)
                .header("Authorization", TokenUtil.getToken())
                .contentType(ContentType.JSON)
                .body(payload)
                .pathParam("id", userId)
            .when()
                .put(Routes.update_user);

        logger.info("Update User Response Status: " + response.getStatusCode());

        return response;
    }

    // ================= DELETE USER =================
    public static Response deleteUser(int userId) {

        logger.info("Using token: " +
                MaskUtil.maskToken(TokenUtil.getToken()));

        logger.info("Deleting user with ID: " + userId);

        Response response =
            given()
                .baseUri(Routes.base_url)
                .header("Authorization", TokenUtil.getToken())
                .pathParam("id", userId)
            .when()
                .delete(Routes.delete_user);

        logger.info("Delete User Response Status: " + response.getStatusCode());

        return response;
    }
}
