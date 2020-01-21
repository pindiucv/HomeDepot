package com.homedepot.smoke_stepDefinitions;

import com.homedepot.pageObjects.sections.HeaderSection;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Header_stepDef {

    private HeaderSection headerSection = new HeaderSection();
    private static ArrayList<String> hrefList = new ArrayList<>();

    @When("^User clicks on the tap header links$")
    public void user_clicks_on_the_tap_header_links() {
        List<WebElement> headerTasksLinks = headerSection.getHeaderTasksLinks();
        for (WebElement temp : headerTasksLinks) {
            String href = temp.getAttribute("href");
            hrefList.add(href);
        }
    }
    @Then("^Then they should open correct pages$")
    public void then_they_should_open_correct_pages()  {
            for (String href : hrefList){
                Assert.assertNotNull(href);
            }
    }







}
