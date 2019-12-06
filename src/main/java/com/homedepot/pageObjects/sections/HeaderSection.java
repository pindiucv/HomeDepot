package com.homedepot.pageObjects.sections;

import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderSection {

    private Library library;

    public HeaderSection() {
        library = new Library();
    }


    public void goToSignInPage() {
        library.click("My Account_button", By.cssSelector(".headerMyAccountTitle.MyAccount__status.hide.show--sm"));
        library.click("Sign In_button", By.cssSelector("[href='//www.homedepot.com/auth/view/signin?redirect=/']"));
    }


    public List<WebElement> getHeaderTasksLinks(){
        List<WebElement> header_task_links = library.findAll("Header task links", By.cssSelector("#TasklinkList>li>a"));
        return header_task_links;
    }

    public void searchForItem(String itemName){
        library.enter("Search Header TextBox", itemName, By.cssSelector("[class='SearchBox__input']"));
        library.click("Search Button", By.cssSelector("[class='SearchBox__buttonIcon']"));
    }

    public List<WebElement> getHeaderTabs(){
        List<WebElement> header_tabs = library.findAll("Header Tabs", By.cssSelector(".ShoppingLinks>li"));
        return header_tabs;
    }

}
