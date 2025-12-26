package com.gorest.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.gorest.api.endpoints.UserEndpoint;
import com.gorest.api.payload.UserPayload;
import com.gorest.api.payload.UserPayloadBuilder;
import com.gorest.api.utilities.BaseTest;

import io.restassured.response.Response;

public class UserCRUDExcelTest extends BaseTest {
	
	@Test(
	        dataProvider = "excelUserData",
	        dataProviderClass = UserExcelDataProvider.class
	    )
	 public void userCRUDFlow(String status, String gender) {

        // CREATE
        UserPayload payload =
                UserPayloadBuilder.buildUserPayload(status, gender);

        Response createResponse =
        		UserEndpoint.createUser(payload);

        Assert.assertEquals(createResponse.getStatusCode(), 201);

        int userId = createResponse.jsonPath().getInt("id");

        // GET
        Response getResponse =
                UserEndpoint.getUser(userId);

        Assert.assertEquals(getResponse.getStatusCode(), 200);

        // UPDATE
        UserPayload updatedPayload =
                UserPayloadBuilder.buildUserPayload("active", gender);

        Response updateResponse =
        		UserEndpoint.updateUser(userId, updatedPayload);

        Assert.assertEquals(updateResponse.getStatusCode(), 200);

        // DELETE
        Response deleteResponse =
        		UserEndpoint.deleteUser(userId);

        Assert.assertEquals(deleteResponse.getStatusCode(), 204);
     // VERIFY DELETE
        Response verifyDelete =
        		UserEndpoint.getUser(userId);

        Assert.assertEquals(verifyDelete.getStatusCode(), 404);
    }

}
