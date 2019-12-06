package com.homedepot.pageObjects.popups;

import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class AddedToCart_PopUp {
    private Library library;

    public AddedToCart_PopUp() {
        library = new Library();
    }


    public void clickOnViewCart(){
        library.click("View Cart button", By.cssSelector(".u__default-link.bttn.bttn--primary.bttn--view-cart-link>span"));

    }



    public void clickOnCheckOut(){
        library.switchToIframe(By.cssSelector(".thd-overlay__content.col__12-12.loading iframe"));
        library.click("CheckOut button", By.cssSelector("[data-automation-id='checkoutNowButton']"));
        library.click("CheckOut As Guest button", By.cssSelector("[name='continueAsGuestButton']>span"));

    }





}
