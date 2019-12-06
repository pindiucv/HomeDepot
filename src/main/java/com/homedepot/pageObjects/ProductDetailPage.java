package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import org.openqa.selenium.By;

public class ProductDetailPage {


    private Library library;

    public ProductDetailPage() {
        library = new Library();
    }


    public void addToCart(){
        library.click("Add To Cart Button", By.xpath("//span[text()='Add to Cart']"));
    }


}
