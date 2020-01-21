@ShoppingCart
Feature: Shopping Cart

  Background:
    Given User selects an item
    And User adds it to shopping cart

  Scenario: Add an item to shopping cart
    Then Verify that item was succsessfully added to shopping cart

  @RemoveItem
  Scenario: Remove an item from shopping cart
    And User removes item from shopping cart
    Then Verify that item is removed successfully


  @IncreaseItemQty
  Scenario: Increase item quantity
    And User increases item quantity
    Then Verify that item quantity is increased

  @SaveToFav
  Scenario: Save an item to Favourites
    When User saves item to Favourites
    Then Item should be saved in default favourites list
