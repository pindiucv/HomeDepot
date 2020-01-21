package com.homedepot.smoke_stepDefinitions;


import com.homedepot.pageObjects.HomeDecorAndFurniturePage;
import com.homedepot.pageObjects.MyFavouritesPage;
import com.homedepot.pageObjects.ShoppingCartPage;
import com.homedepot.pageObjects.popups.AddedToCart_PopUp;
import com.homedepot.pageObjects.popups.SaveToFavourites_PopUp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class ShoppingCart_stepDef {

    private HomeDecorAndFurniturePage homeDecorAndFurniturePage = new HomeDecorAndFurniturePage();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private AddedToCart_PopUp addedToCart_popUp = new AddedToCart_PopUp();
    private SaveToFavourites_PopUp saveToFavourites_popUp = new SaveToFavourites_PopUp();
    private MyFavouritesPage myFavouritesPage = new MyFavouritesPage();




    @Given("^User selects an item$")
    public void user_selects_an_item() {
        homeDecorAndFurniturePage.selectItem_HomeDecorAndFurniture(1);
    }

    @And("^User adds it to shopping cart$")
    public void user_adds_it_to_shopping_cart() {
        homeDecorAndFurniturePage.addItemToCart(0);
    }

    @Then("^Verify that item was succsessfully added to shopping cart$")
    public void verify_that_item_was_succsessfully_added_to_shopping_cart()  {
        String actualText = addedToCart_popUp.shoppingCartViewHeader.getText();
        Assert.assertEquals("1 Item Added to Cart", actualText);
    }

    @And("^User removes item from shopping cart$")
    public void user_removes_item_from_shopping_cart() {
        addedToCart_popUp.clickOnViewCart();
        shoppingCartPage.removeItemFromCart();
    }

    @Then("^Verify that item is removed successfully$")
    public void verify_that_item_is_removed_successfully(){
        String actualText = addedToCart_popUp.emptyShoppingCartMsg.getText();
        Assert.assertEquals("Your shopping cart is empty.", actualText);
    }

    @And("^User increases item quantity$")
    public void user_increases_item_quantity()  {
        addedToCart_popUp.clickOnViewCart();
      shoppingCartPage.increaseItemQuantity("3");
    }

    @Then("^Verify that item quantity is increased$")
    public void verify_that_item_quantity_is_increased() {
        String value = shoppingCartPage.itemQtyBox.getAttribute("value");
        Assert.assertEquals("3", value);
    }


    @When("^User saves item to Favourites$")
    public void user_saves_item_to_Favourites()  {
        addedToCart_popUp.clickOnViewCart();
        shoppingCartPage.clickSaveToFavourites();

    }

    @Then("^Item should be saved in default favourites list$")
    public void item_should_be_saved_in_default_favourites_list() {
        saveToFavourites_popUp.viewFavourites();
        Assert.assertFalse(myFavouritesPage.isListEmpty());
    }

}
