package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import com.homedepot.pageObjects.popups.SaveToFavourites_PopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {


    private Library library;
    private SaveToFavourites_PopUp saveToFavourites_popUp = new SaveToFavourites_PopUp();

    @FindBy(css = "[data-automation-id='removeItem']")
    public WebElement removeButton;
    @FindBy(xpath = "//a[text()='Save to Favorites']")
    public WebElement saveToFavourites;
    @FindBy(css = "[type='tel']")
    public WebElement itemQtyBox;



    public ShoppingCartPage() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }

  public void clickOnCheckOut(){

        library.click("Checkout Button", By.cssSelector("[data-automation-id='cartMainSummaryCheckoutOptionsContainer'] button"));

  }
    public void increaseItemQuantity(String quantity){
       itemQtyBox.click();
        itemQtyBox.clear();
        itemQtyBox.sendKeys(quantity);
    }

    public void removeItemFromCart(){
        removeButton.click();
    }

    public void clickSaveToFavourites(){
        saveToFavourites.click();
    }


}
