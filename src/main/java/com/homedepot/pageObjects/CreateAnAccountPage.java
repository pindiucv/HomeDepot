package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;

import java.util.Random;

public class CreateAnAccountPage {


    private Library library;

    public CreateAnAccountPage() {
        library = new Library();
    }

    public void fillOut() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        library.enter("Email text_box", "vero"+ randomInt + "@gmail.com", By.cssSelector("[name='email']"));
        //driver.findElement(By.id("id of the element").SendKeys("Automation_" + Number.Next(1, 1000).ToString() + "_" + driver.RandomString(4) + "@gmail.com"));

        library.enter("Password text_box", "Cyram123", By.cssSelector("[name='password']"));
        library.enter("ZipCode text_box", "60634", By.cssSelector("[name='zipcode']"));

        int last4Num= randomGenerator.nextInt(10000);
        String cellNum = ("123456" + last4Num);
        library.enter("Phone text_box", cellNum, By.cssSelector("[name='phone']"));

        library.click("Create Account button", By.cssSelector("[data-automation-id='registrationCreateAnAccountButton']>span"));
        library.click("Skip for now & Continue Shopping button", By.cssSelector("[data-automation-id='subscriptionsSkipForNowContinueShoppingButton']>span"));

    }

}
