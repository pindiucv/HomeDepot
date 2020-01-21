package com.homedepot.pageObjects.sections;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderSection {

    private Library library;
    @FindBy(css = "a>#headerMyAccountTitle>span")
   public WebElement loginHeader;
    @FindBy(css = ".headerMyAccountTitle.MyAccount__status.hide.show--sm")
    WebElement myAccountButton;
    @FindBy(css = "[href='//www.homedepot.com/auth/view/signin?redirect=/']")
    WebElement signInButton;
    @FindBy(css = "[class='SearchBox__buttonIcon']")
    WebElement searchButton;
    @FindBy(css = "[class='SearchBox__input']")
    WebElement searchHeaderTextBox;
    @FindBy(css = "#TasklinkList>li>a")
    List<WebElement> headerTaskLinks;
    @FindBy(css = ".ShoppingLinks>li")
    List<WebElement> headerTabs;


    public HeaderSection() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }


    public void goToSignInPage() {
        myAccountButton.click();
        library.click(signInButton);
    }

    public List<WebElement> getHeaderTasksLinks() {
        return headerTaskLinks;
    }

    public void searchForItem(String itemName) {
        searchHeaderTextBox.sendKeys(itemName);
        searchButton.click();
    }

    public List<WebElement> getHeaderTabs() {
        return headerTabs;
    }

}
