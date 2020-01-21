package com.homedepot.pageObjects.popups;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddedToCart_PopUp {
    private Library library;

    @FindBy(css = ".thd-overlay__header span:nth-of-type(2)")
   public WebElement shoppingCartViewHeader;
    @FindBy(css = "[data-automation-id='appEmptyShoppingCartText']")
   public WebElement emptyShoppingCartMsg;
    @FindBy(css = ".u__default-link.bttn.bttn--primary.bttn--view-cart-link>span")
    public WebElement viewCartButton;
    @FindBy(css = ".thd-overlay__content.col__12-12.loading iframe")
    public WebElement iFrame;


    public AddedToCart_PopUp() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }
    public void clickOnViewCart(){
        library.switchToIframe(iFrame);
        library.click(viewCartButton);

    }

    public void clickOnCheckOut(){
        library.switchToIframe(By.cssSelector(".thd-overlay__content.col__12-12.loading iframe"));
        library.click("CheckOut button", By.cssSelector("[data-automation-id='checkoutNowButton']"));
        library.click("CheckOut As Guest button", By.cssSelector("[name='continueAsGuestButton']>span"));

    }





}
