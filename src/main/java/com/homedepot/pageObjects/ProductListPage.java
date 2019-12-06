package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPage {

    private Library library;

    public ProductListPage() {
        library = new Library();
    }

    private By productList = By.cssSelector(".product-result__wrapped-results>div>div");

    public void selectAProduct(int index) {

        List<WebElement> all_item_options = library.findAll("All item Options", productList);
        library.scrollToElement(all_item_options.get(index));
        all_item_options.get(index).click();
        library.switchTab();
    }

    public void hoverOverAnItemAndAddToCart(int elementIndex){
        List<WebElement> all_item_options = library.findAll("All item Options", productList);
        library.scrollToElement(all_item_options.get(elementIndex));
        library.hoverOver("Add to cart_button", all_item_options.get(elementIndex));
        library.click("Add to cart_button", By.xpath("(//span[@class='bttn__content'])[4]"));

    }

    public By getProductListLocator(){

        return productList;
    }






}
