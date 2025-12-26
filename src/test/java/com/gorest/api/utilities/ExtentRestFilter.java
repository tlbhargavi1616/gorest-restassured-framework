package com.gorest.api.utilities;

import com.aventstack.extentreports.ExtentTest;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class ExtentRestFilter implements Filter {

    private ExtentTest test;

    public ExtentRestFilter(ExtentTest test) {
        this.test = test;
    }

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        if (test != null) {
            test.info("REQUEST: " + requestSpec.getMethod() +
                    " " + requestSpec.getURI());
        }

        Response response = ctx.next(requestSpec, responseSpec);

        if (test != null) {
            test.info("RESPONSE STATUS: " + response.getStatusCode());
        }

        return response;
    }
}
