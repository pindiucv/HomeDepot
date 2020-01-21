package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class CreateAnAccountPage {


    private Library library;
    @FindBy(css = "[name='email']")
    WebElement emailTextBox;
    @FindBy(css = "[name='password']")
    WebElement passwordTextBox;
    @FindBy(css = "[name='zipcode']")
    WebElement zipCodeTextBox;
    @FindBy(css = "[name='phone']")
    WebElement phoneTextBox;
    @FindBy(css = "[data-automation-id='registrationCreateAnAccountButton']>span")
    WebElement createAccountButton;
    @FindBy(css = "[data-automation-id='subscriptionsSkipForNowContinueShoppingButton']>span")
    WebElement skipAndContinueShoppingButton;



    public CreateAnAccountPage() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }

    public void fillOut() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        emailTextBox.sendKeys("vero"+ randomInt + "@gmail.com");
        passwordTextBox.sendKeys("Cyram123");
        zipCodeTextBox.sendKeys("60634");

        int last4Num= randomGenerator.nextInt(10000);
        String cellNum = ("123456" + last4Num);
        phoneTextBox.sendKeys(cellNum);
        library.click(createAccountButton);
        skipAndContinueShoppingButton.click();
    }

}
