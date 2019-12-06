package com.homedepot.smoke_tests;

import com.homedepot.base.Base;
import com.homedepot.pageObjects.HomeDecorAndFurniturePage;
import com.homedepot.pageObjects.ShoppingCartPage;
import com.homedepot.pageObjects.popups.AddedToCart_PopUp;
import com.homedepot.pageObjects.popups.SaveToFavourites_PopUp;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCart_Test extends Base {


    private AddedToCart_PopUp addedToCart_popUp = new AddedToCart_PopUp();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private HomeDecorAndFurniturePage homeDecorAndFurniturePage = new HomeDecorAndFurniturePage();

    @Test
    public void addItemToCart_Test() {
        homeDecorAndFurniturePage.selectItem_HomeDecorAndFurniture(1);
        String actualText = library.find("Shopping cart view header", By.cssSelector(".thd-overlay__header span:nth-of-type(2)")).getText();
        System.out.println(actualText);
        Assert.assertEquals("1 Item Added to Cart", actualText);
    }

    @Test
    public void increaseItemQuantity_Test() {
        homeDecorAndFurniturePage.selectItem_HomeDecorAndFurniture(2);
        addedToCart_popUp.clickOnViewCart();
        By itemQuantityBoxLocator = shoppingCartPage.increaseItemQuantity("3");
        String value = library.find("Quantity box", itemQuantityBoxLocator).getAttribute("value");
        Assert.assertEquals("3", value);
    }

    @Test
    public void removeItemFromCart_Test() {
        homeDecorAndFurniturePage.selectItem_HomeDecorAndFurniture(2);
        addedToCart_popUp.clickOnViewCart();
        shoppingCartPage.removeItemFromCart();
        String actualText = library.find("Empty shopping cart msg", By.cssSelector("[data-automation-id='appEmptyShoppingCartText']")).getText();
        System.out.println(actualText);
        Assert.assertEquals("Your shopping cart is empty.", actualText);
    }

    @Test
    public void saveToFavourites_Test() {
        homeDecorAndFurniturePage.selectItem_HomeDecorAndFurniture(1);
        addedToCart_popUp.clickOnViewCart();
        shoppingCartPage.clickSaveToFavourites();
        List<WebElement> saved_favourite_items = library.findAll("Saved Favourite items", By.cssSelector(".grid>list-item-details"));
        Assert.assertTrue(saved_favourite_items.size() > 0);
    }
}

