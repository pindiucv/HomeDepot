package com.homedepot.smoke_tests;

import com.homedepot.base.Base;
import com.homedepot.pageObjects.SignInPage;
import com.homedepot.pageObjects.sections.HeaderSection;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class Login_Test extends Base {

    private HeaderSection headerSection = new HeaderSection();
    private SignInPage signInPage = new SignInPage();

    //Correct username and password. Positive Test
    @Test
    public void validLogin_Test() {
        headerSection.goToSignInPage();
        signInPage.signIn("appletreeappletree78@gmail.com", "automation100");
        String actualText = library.find("Logged In header", By.cssSelector("a>#headerMyAccountTitle>span")).getText();
        Assert.assertEquals("Welcome", actualText);
    }

    //Incorrect username or password. Negative Test
    @Test
    public void invalidLogin_Test() {
        headerSection.goToSignInPage();
        signInPage.signIn("appletreeappletree78@gmail.com", "automation1001");
        String actual = driver.getCurrentUrl();
        System.out.println(actual);
        Assert.assertEquals("https://www.homedepot.com/", actual);
    }

    //Create a new Account
    @Test
    public void createNewAccount_Test(){
        headerSection.goToSignInPage();
        signInPage.clickOnCreateAccount()
                   .fillOut();
        String actualText = library.find("Logged In header", By.cssSelector("a>#headerMyAccountTitle>span")).getText();
        Assert.assertEquals("Welcome", actualText);
    }
}