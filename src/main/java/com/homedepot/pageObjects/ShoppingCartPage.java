package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import com.homedepot.pageObjects.popups.SaveToFavourites_PopUp;
import org.openqa.selenium.By;

public class ShoppingCartPage {


    private Library library;
    private SaveToFavourites_PopUp saveToFavourites_popUp = new SaveToFavourites_PopUp();

    public ShoppingCartPage() {
        library = new Library();
    }



  public void clickOnCheckOut(){

        library.click("Checkout Button", By.cssSelector("[data-automation-id='cartMainSummaryCheckoutOptionsContainer'] button"));

  }
    public By increaseItemQuantity(String quantity){

        By by = By.cssSelector("[type='tel']");
        library.click("Quantity box", by);
        library.find("Quantity box", by).clear();
        library.enter("Quantity box", quantity, by);
        return by;
    }

    public void removeItemFromCart(){
        library.click("Remove Button", By.cssSelector("[data-automation-id='removeItem']"));
    }

    public void clickSaveToFavourites(){
        library.click("Save To Favourites Hyperlink", By.xpath("//a[text()='Save to Favorites']"));
        saveToFavourites_popUp.clickOnSaveButton()
                .clickOnViewFavourites_HyperLink();
    }


}
