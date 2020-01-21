package com.homedepot.pageObjects;

import com.homedepot.base.Base;
import com.homedepot.common.Library;
import com.homedepot.pageObjects.sections.HeaderSection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomeDecorAndFurniturePage {

    private Library library;
    private HeaderSection headerSection = new HeaderSection();
    private ProductListPage productListPage = new ProductListPage();

    @FindBy(xpath = "(//div[@class='homeDecorFurnitureFlyout__bay  '])[6]/div/a") List<WebElement> getFragranceAndCandlesLinks;
    @FindBy(xpath = "(//div[@class='homeDecorFurnitureFlyout__bay  '])[1]/div/a")  List<WebElement> getWallDecorLinks;


    public HomeDecorAndFurniturePage() {
        library = new Library();
        PageFactory.initElements(Base.getDriver(), this);
    }


    public List<WebElement> getFragranceAndCandlesLinks() {
        return getFragranceAndCandlesLinks;

    }
    public List<WebElement> getWallDecorLinks() {
        return getWallDecorLinks;

    }
    public void selectItem_HomeDecorAndFurniture(int optionIndex) {
        List<WebElement> headerTabs = headerSection.getHeaderTabs();
        library.hoverOver("Home Decor & Furniture option", headerTabs.get(1));
        WebElement item = getWallDecorLinks().get(optionIndex);
        item.click();
    }
   public void addItemToCart(int optionIndex){
       productListPage.hoverOverAnItem(optionIndex);
       productListPage.addToCart();
   }
}
