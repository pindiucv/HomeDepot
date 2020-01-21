package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListPage {

    private Library library;

    public ProductListPage() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }
    @FindBy(xpath = "(//button[@class='bttn bttn--primary'])[1]") WebElement addToCartButton;


    private By productList = By.cssSelector(".product-result__wrapped-results>div>div");

    public void selectAProduct(int index) {

        List<WebElement> all_item_options = library.findAll("All item Options", productList);
        library.scrollToElement(all_item_options.get(index));
        all_item_options.get(index).click();
        library.switchTab();
    }

    public void hoverOverAnItem(int elementIndex) {
        List<WebElement> all_item_options = library.findAll("All item Options", productList);
        library.scrollToElement(all_item_options.get(elementIndex));
        library.hoverOver("Add to cart_button", all_item_options.get(elementIndex));
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public By getProductListLocator() {
        return productList;
    }


}
