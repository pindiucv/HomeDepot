package com.homedepot.pageObjects.popups;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveToFavourites_PopUp {
    private Library library;

    public SaveToFavourites_PopUp() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButton;
    @FindBy(css = "div>.list--link.u--show .u__default-link")
    public WebElement viewFavouritesHyperLink;

    public void viewFavourites() {

        library.click(saveButton);
        viewFavouritesHyperLink.click();
    }


}
