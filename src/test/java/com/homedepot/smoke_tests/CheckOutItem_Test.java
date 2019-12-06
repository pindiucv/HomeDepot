package com.homedepot.smoke_tests;

import com.homedepot.base.Base;
import com.homedepot.pageObjects.ProductDetailPage;
import com.homedepot.pageObjects.ProductListPage;
import com.homedepot.pageObjects.SecureCheckOutPage;
import com.homedepot.pageObjects.ShoppingCartPage;
import com.homedepot.pageObjects.popups.AddedToCart_PopUp;
import com.homedepot.pageObjects.sections.HeaderSection;
import org.junit.Test;

public class CheckOutItem_Test extends Base {


    private HeaderSection headerSection = new HeaderSection();
    private ProductListPage productListPage = new ProductListPage();
    private AddedToCart_PopUp addedToCart_popUp = new AddedToCart_PopUp();
    private SecureCheckOutPage secureCheckOutPage = new SecureCheckOutPage();
    private ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    private ProductDetailPage productDetailPage = new ProductDetailPage();

    @Test
    public void checkOutItem() {

        headerSection.searchForItem("Couch");
        productListPage.selectAProduct(16);
        productDetailPage.addToCart();
        addedToCart_popUp.clickOnCheckOut();
        secureCheckOutPage.placeOrder();
    }
}
