package com.homedepot.pageObjects.popups;

import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class SaveToFavourites_PopUp {
    private Library library;

    public SaveToFavourites_PopUp() {
        library = new Library();
    }


    public SaveToFavourites_PopUp clickOnSaveButton(){
        library.click("Save Button", By.cssSelector("div>.bttn.bttn--primary.bttn--inline"));
        return this;
    }

    public SaveToFavourites_PopUp clickOnViewFavourites_HyperLink(){
        library.click("View Favourites HyperLink", By.cssSelector("div>.list--link.u--show .u__default-link"));
        return this;
    }


}
