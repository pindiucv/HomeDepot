package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private Library library;
    @FindBy(css = "[placeholder='Enter Email Address']")
    WebElement emailTextBox;
    @FindBy(css = "#password-input-field")
    WebElement passwordTextBox;
    @FindBy(css = ".bttn--primary")
    WebElement signInButton;
    @FindBy(css = "[data-automation-id='signInCreateAnAccountButton']>span")
    WebElement clickOnCreateAccount;


    public SignInPage() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }

    public void signIn(String username, String password) {
        emailTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        signInButton.click();
    }

    public void clickOnCreateAccount() {
        clickOnCreateAccount.click();
    }


}
