package com.homedepot.smoke_stepDefinitions;

import com.homedepot.common.Library;
import com.homedepot.pageObjects.CreateAnAccountPage;
import com.homedepot.pageObjects.SignInPage;
import com.homedepot.pageObjects.sections.HeaderSection;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;


public class CreateNewAccount_stepDef {


    private SignInPage signInPage = new SignInPage();
    private Library library = new Library();
    private CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
    private HeaderSection headerSection = new HeaderSection();

    @Given("^User clicks on Create Account button$")
    public void user_clicks_on_Create_Account_button()  {
        signInPage.clickOnCreateAccount();
    }

    @Given("^User fills out account creation form$")
    public void user_fills_out_account_creation_form() {
     createAnAccountPage.fillOut();
    }

    @Then("^Verify that user created an account$")
    public void verify_that_user_created_an_account()  {
        String actualText = headerSection.loginHeader.getText();
        Assert.assertEquals("Welcome", actualText);
    }










}
