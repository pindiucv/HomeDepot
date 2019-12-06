package com.homedepot.smoke_tests;

import com.homedepot.base.Base;
import com.homedepot.common.CustomWait;
import com.homedepot.pageObjects.HomeDecorAndFurniturePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemAddedToCartPopUp_Test extends Base {


    private HomeDecorAndFurniturePage homeDecorAndFurniturePage = new HomeDecorAndFurniturePage();
    private CustomWait wait = new CustomWait();

    @Test
    public void suggestedItems_Right_Left_Arrow_Buttons_Test(){
        homeDecorAndFurniturePage.selectItem_HomeDecorAndFurniture(1);
        WebElement nextArrowRightButton = library.find("Next Arrow_Button", By.cssSelector("div>svg.carousel__next-button"));
        WebElement prevArrowLeftButton = library.find("Prev Arrow_Button", By.cssSelector("div>svg.carousel__prev-button"));
        boolean next_clickable = wait.isClickable(nextArrowRightButton);
        nextArrowRightButton.click();
        boolean prev_clickable = wait.isClickable(prevArrowLeftButton);
        Assert.assertTrue(next_clickable);
        Assert.assertTrue(prev_clickable);

    }












}
