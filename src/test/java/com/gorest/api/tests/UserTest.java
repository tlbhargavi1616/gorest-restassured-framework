package com.gorest.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gorest.api.endpoints.UserEndpoint;
import com.gorest.api.payload.UserPayload;
import com.gorest.api.payload.UserPayloadBuilder;
import com.gorest.api.utilities.BaseTest;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import com.gorest.api.utilities.TokenUtil;

public class UserTest extends BaseTest {
	
	 int userId;

	    // ============ CREATE USER ============
	    @Test(priority = 1)
	    public void testCreateUser() {
	    	
	    	

	        UserPayload userPayload =
	                UserPayloadBuilder.buildUserPayload("active", "female");

	        Response response =
	        		UserEndpoint.createUser(userPayload);

	        response.then().log().all();

	        // GoRest returns 201 for successful creation
	        Assert.assertEquals(response.getStatusCode(), 201);

	        userId = response.jsonPath().getInt("id");
	        Assert.assertTrue(userId > 0);
	    }

	    // ============ GET USER ============
	    @Test(priority = 2)
	    public void testGetUser() {

	        Response response =
	        		UserEndpoint.getUser(userId);

	        response.then().log().all();

	        Assert.assertEquals(response.getStatusCode(), 200);
	        Assert.assertEquals(
	                response.jsonPath().getString("id"),
	                String.valueOf(userId)
	        );
	    }
	    
	 // ================= UPDATE USER =================
	    @Test(priority = 3)
	    public void testUpdateUser() {

	        UserPayload updatedPayload =
	                UserPayloadBuilder.buildUserPayload("active", "female");

	        Response response =
	        		UserEndpoint.updateUser(userId, updatedPayload);

	        response.then().log().all();

	        Assert.assertEquals(response.getStatusCode(), 200);

	        Assert.assertEquals(
	                response.jsonPath().getString("status"),
	                updatedPayload.getStatus()
	        );
	    }

	    // ================= DELETE USER =================
	    @Test(priority = 4)
	    public void testDeleteUser() {

	        Response response =
	        		UserEndpoint.deleteUser(userId);

	        response.then().log().all();

	        Assert.assertEquals(response.getStatusCode(), 204);
	    }

	    // ================= VERIFY DELETED USER =================
	    @Test(priority = 5)
	    public void testGetDeletedUser() {

	        Response response =
	        		UserEndpoint.getUser(userId);

	        response.then().log().all();

	        Assert.assertEquals(response.getStatusCode(), 404);
	    }

}
