package com.gorest.api.payload;

import com.github.javafaker.Faker;


public class UserPayloadBuilder {
	
	
	  private static Faker faker = new Faker();

	  public static UserPayload buildUserPayload(String status, String gender) {


		   UserPayload user = new UserPayload();
	        user.setName(faker.name().fullName());
	        user.setEmail(faker.internet().emailAddress());
	        user.setGender(gender);
	        user.setStatus(status);

	        return user;
	    }

}
