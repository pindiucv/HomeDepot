package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class SecureCheckOutPage {

    private Library library;

    public SecureCheckOutPage() {
        library = new Library();
    }

    public void placeOrder(){
        fillOutShippingInfo();
        fillOutPaymentInfo();
        library.click("Place Order Button", By.cssSelector("[name='placeOrderButton']"));
    }

    private void fillOutShippingInfo() {

        library.enter("First Name textBox", "Thomas", By.cssSelector("[name='firstName']"));
        library.enter("Last Name textBox", "Bors", By.cssSelector("[name='lastName']"));
        library.enter("Email textBox", "thomas@gmail.com", By.cssSelector("[name='email']"));
        library.enter("Phone Number textBox", "3022655155", By.cssSelector("[name='phone']"));
        library.enter("Address textBox", "6334 W Irving Park Rd", By.cssSelector("[name='line1']"));
        library.enter("ZipCode textBox", "60634", By.cssSelector("[name='zipCodeField']"));

    }

      private void fillOutPaymentInfo(){

        library.enter("Credit Card Number", "5105 1051 0510 5100", By.cssSelector("[name='cardNumber']"));
        library.selectDropdownByValue(By.cssSelector("[name='cardExpiryMonth']"), "12");
        library.selectDropdownByValue(By.cssSelector("[name='cardExpiryYear']"), "2022");
        library.enter("CVV textBox", "675", By.cssSelector("[name='cvvField']"));

    }










}
