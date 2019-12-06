package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class SignInPage {


    private Library library;
   

    public SignInPage() {
        library = new Library();
    }

    public void signIn(String username, String password){

        library.enter("Email text_box", username, By.cssSelector("[placeholder='Enter Email Address']"));
        library.enter("Password text_box",password, By.cssSelector("#password-input-field"));
        library.click("Sign in button", By.cssSelector(".bttn--primary"));
    }

    public CreateAnAccountPage clickOnCreateAccount() {
    library.click("Create An Account Button", By.cssSelector("[data-automation-id='signInCreateAnAccountButton']>span"));
    return new CreateAnAccountPage();
    }





}
