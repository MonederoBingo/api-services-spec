/* Copyright 2016 Sabre Holdings */
package com.monederobingo.step_definitions;

import com.monederobingo.tests.use_cases.auth.registration.company.SuccessfulRegistration;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompanyRegistration
{
    SuccessfulRegistration successfulRegistration = new SuccessfulRegistration();

    @Given("^User provides correct registration information$")
    public void test()
    {

    }

    @When("^User send registration request$")
    public void userSendRegistrationRequest() throws Throwable
    {
        //successfulRegistration.sendRegistrationRequest();
    }

    @Then("^The user should receive a message with message saying that was successfully added$")
    public void theUserShouldReceiveAMessageWithMessageSayingThatWasSuccessfullyAdded() throws Throwable
    {
       // successfulRegistration.asserts();
    }
}