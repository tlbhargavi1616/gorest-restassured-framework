package com.gorest.api.utilities;

import org.testng.annotations.BeforeMethod;
import io.restassured.RestAssured;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {

	@BeforeMethod
	public void setUp() {
	    ExtentTest test = ExtentTestListener.getTest();
	    RestAssured.filters(new ExtentRestFilter(test));
	}

}
