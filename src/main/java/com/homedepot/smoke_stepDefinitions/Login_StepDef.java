package com.homedepot.smoke_stepDefinitions;


import com.homedepot.base.Base;
import com.homedepot.common.Library;
import com.homedepot.pageObjects.SignInPage;
import com.homedepot.pageObjects.sections.HeaderSection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class Login_StepDef {

    private HeaderSection headerSection = new HeaderSection();
    private SignInPage signInPage = new SignInPage();
    private Library library = new Library();


    @Given("^User is on login page$")
    public void user_is_on_login_page() {
        headerSection.goToSignInPage();
    }

    @Given("^User enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_username_and_password(String arg1, String arg2) {
        signInPage.signIn(arg1, arg2);
    }

    @Then("^Verify that user can see \"([^\"]*)\" after logged in$")
    public void verify_that_user_can_see_after_logged_in(String arg1)  {
        String actualText = headerSection.loginHeader.getText();
        Assert.assertEquals(arg1, actualText);
    }

    @Given("^User enters incorrect username \"([^\"]*)\" and valid password \"([^\"]*)\"$")
    public void user_enters_incorrect_username_and_valid_password(String arg1, String arg2){
        signInPage.signIn(arg1, arg2);
    }

    @Then("^Verify that user cannot successfully logged in$")
    public void verify_that_user_cannot_successfully_logged_in() {
        String actual = Base.getDriver().getCurrentUrl();
        Assert.assertEquals("https://www.homedepot.com/", actual);
    }



}
