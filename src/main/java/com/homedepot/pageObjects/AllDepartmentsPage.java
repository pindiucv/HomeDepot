package com.homedepot.pageObjects;

import com.homedepot.common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllDepartmentsPage {


    private Library library;

    public AllDepartmentsPage() {
        library = new Library();
    }


    public List<WebElement> getAllDepartmentsLinks() {
        List<WebElement> all = library.findAll("Departments Links", By.cssSelector(".MainFlyout__level1 ul>li>a"));
        return all;
    }


}
