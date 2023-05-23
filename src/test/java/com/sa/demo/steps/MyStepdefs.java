package com.sa.demo.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sa.demo.model.Employee;
import com.sa.demo.utils.ScenarioContext;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MyStepdefs {

    private int employeeId;

    private Response response;

    @Value("${base.uri}")
    private String baseUri;

    @Autowired
    private ScenarioContext scenarioContext;

    @Autowired
    private Employee employee;


    @ParameterType("\\d+")
    public Integer integer(String value) {
        return Integer.parseInt(value);
    }


    @Given("the user has entered {int} as their age")
    public void theUserHasEnteredIdAsTheirAge(int age) {
        System.out.println(age);
    }

    @Given("the employee ID is {int}")
    public void theEmployeeIDIsId(int employeeId) {
        this.employeeId = employeeId;
        System.out.println(employeeId);
    }

    @Given("the employee's first name is {string}")
    public void theEmployeeSFirstNameIs(String firstName) {
        employee.setFirstName(firstName);
    }

    @And("the employee's last name is {string}")
    public void theEmployeeSLastNameIs(String lastName) {
        employee.setLastName(lastName);
    }

    @And("the employee's email is {string}")
    public void theEmployeeSEmailIs(String email) {
        employee.setEmail(email);
    }

    @When("the create employee API is called")
    public void theCreateEmployeeAPIIsCalled() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(employee);
        response = given()
                .baseUri(baseUri)
                .basePath("/employee")
                .contentType("application/json")
                .port(8080)
                .body(requestBody)
                .when()
                .post();

        scenarioContext.setContext("response",response);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(201);
    }

    @And("the response body should contain the employee's id, first name, last name, and email")
    public void theResponseBodyShouldContainTheEmployeeSIdFirstNameLastNameAndEmail() {
        response.then().body("firstName", equalTo(employee.getFirstName()));
        response.then().body("lastName", equalTo(employee.getLastName()));
        response.then().body("email", equalTo(employee.getEmail()));
    }
}
