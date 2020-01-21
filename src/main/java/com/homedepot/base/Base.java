package com.homedepot.base;

import com.homedepot.common.Library;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;


public class Base {
    public Library library;
    private static WebDriver driver;

    public Base() {
        library = new Library();
    }

    @Before
    public void setup() {
        driver = library.openBrowser();
    }

    @After
    public void tearDown() {
        library.waitFor(2);
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }



}
