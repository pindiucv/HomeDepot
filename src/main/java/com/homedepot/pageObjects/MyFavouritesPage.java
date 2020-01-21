package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyFavouritesPage {


    @FindBy(css = ".grid>list-item-details")
     List<WebElement> savedFavouriteItems;

    public MyFavouritesPage() {
        PageFactory.initElements(Base.getDriver(), this);
    }


    public boolean isListEmpty() {
        return savedFavouriteItems.size() <= 0;
    }


}
