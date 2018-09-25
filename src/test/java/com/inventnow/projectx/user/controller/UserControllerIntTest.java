package com.inventnow.projectx.user.controller;

import com.inventnow.projectx.AbstractIntTest;
import com.inventnow.projectx.util.TestCaseUtil;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Value;

import static com.jayway.restassured.RestAssured.given;

public class UserControllerIntTest extends AbstractIntTest {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    @Value("${local.server.port}")
    private int port;

    private static final String USER_ADMIN_REGISTRATION = "/pex-api/v1/users/signup";

    @Given("^a customer want to register with data \"([^\"]*)\"$")
    public void a_customer_want_to_register_with_data(String requestSamplePath) {
        String requestSample = TestCaseUtil.getContentFromFilePath(requestSamplePath);
        request = given().accept(ContentType.JSON).contentType(ContentType.JSON).port(port).body(requestSample);
    }

    @When("^a customer send his data to API$")
    public void a_customer_send_his_data_to_API() {
        response = request.when()
                .post(USER_ADMIN_REGISTRATION);
        System.out.println("response: " + response.prettyPrint());
    }

    @Then("^the status code is (\\d+)$")
    public void the_status_code_is(int statusCode) {
        json = response.then().statusCode(statusCode);
    }

}