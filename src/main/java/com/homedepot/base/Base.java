package com.homedepot.base;

import com.homedepot.common.Library;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class Base {
    public Library library;
    public WebDriver driver;

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



}
