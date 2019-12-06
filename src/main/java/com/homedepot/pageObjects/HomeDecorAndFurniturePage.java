package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import com.homedepot.pageObjects.sections.HeaderSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeDecorAndFurniturePage {

    private Library library;
    private HeaderSection headerSection = new HeaderSection();
    private ProductListPage productListPage = new ProductListPage();

    public HomeDecorAndFurniturePage() {
        library = new Library();
    }


    public List<WebElement> getFragranceAndCandlesLinks() {
        List<WebElement> all = library.findAll("Fragrance And Candles Links", By.xpath("(//div[@class='homeDecorFurnitureFlyout__bay  '])[6]/div/a"));
        return all;

    }
    public List<WebElement> getWallDecorLinks() {
        List<WebElement> all = library.findAll("Fragrance And Candles Links", By.xpath("(//div[@class='homeDecorFurnitureFlyout__bay  '])[1]/div/a"));
        return all;

    }
    public void selectItem_HomeDecorAndFurniture(int optionIndex) {
        List<WebElement> headerTabs = headerSection.getHeaderTabs();
        library.hoverOver("Home Decor & Furniture option", headerTabs.get(1));
        WebElement item = getWallDecorLinks().get(optionIndex);
        item.click();
        productListPage.hoverOverAnItemAndAddToCart(0);
        library.switchToIframe(By.cssSelector(".thd-overlay__content.col__12-12.loading iframe"));
    }

}
