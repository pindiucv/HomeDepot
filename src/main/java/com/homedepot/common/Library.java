package com.homedepot.common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Library {

    public static WebDriver driver;
    public CustomWait wait = new CustomWait();;

    private String config_filePath = "C:\\Users\\Dell R2\\IdeaProjects\\Cyram_automation\\homedepot\\src\\main\\resources\\properties";


    public WebDriver openBrowser() {
        String browser = "chrome";
        String browser2 = "firefox";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell R2\\IdeaProjects\\Cyram_automation\\homedepot\\src\\main\\resources\\drivers\\chromedriver.exe");

        if (readProperties("browser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (readProperties("browser").equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get(readProperties("url"));
        driver.manage().window().setSize(new Dimension(1600, 1300));
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public void enter(String elementName, String value, By by) {
        if (by instanceof By.ByXPath || by instanceof By.ByCssSelector || by instanceof By.ById) {
            WebElement element = wait.waitUntilPresent(by);
            element.clear();
            element.sendKeys(value);
        } else
            System.err.println("Locator is not implemented");
    }

    public void click(String elementName, By by) {
        if (by instanceof By.ByXPath || by instanceof By.ByCssSelector || by instanceof By.ById)
            wait.waitUntilClickable(by).click();
        else
            System.err.println("Locator is not implemented");
    }

    public WebElement find(String elementName, By by) {
        return wait.waitUntilPresent(by);
    }

    public List<WebElement> findAll(String elementName, By by) {
        List<WebElement> webElements = wait.waitUntilAllPresent(by);
        return webElements;
    }



    public void selectDropdownByValue(By by, String value) {
        if (by instanceof By.ByXPath || by instanceof By.ByCssSelector || by instanceof By.ById) {
            WebElement dropdown = wait.waitUntilPresent(by);
            Select select = new Select(dropdown);
            select.selectByValue(value);
        }
    }

    public void selectDropdownByText(String elementName, String value, By by) {
        if (by instanceof By.ByXPath || by instanceof By.ByCssSelector || by instanceof By.ById) {
            WebElement dropdown = wait.waitUntilPresent(by);
            Select select = new Select(dropdown);
            select.selectByVisibleText(value);
        }
    }


    public String readProperties(String key) {
        File file = new File(config_filePath);
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

    public void waitFor(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollDown(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(" + x + "," + (y * 2000) + ") ");
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        waitFor(1);
    }

    public void switchToIframe(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void hoverOver(String elementName, By by) {
        WebElement element = wait.waitUntilVisible(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void hoverOver(String elementName, WebElement element) {
        WebElement element1 = wait.waitUntilVisible(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).build().perform();
    }

    public void switchTab() {
        String windowHandle = driver.getWindowHandle();
        for (String s : driver.getWindowHandles()) {
            if (!s.equals(windowHandle)) {
                driver.switchTo().window(s);
            }
        }
        waitFor(1);
    }

}