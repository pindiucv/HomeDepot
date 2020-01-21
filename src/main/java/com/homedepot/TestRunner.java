package com.homedepot;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"
        , "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
        , monochrome = true
        , features = "src/main/resources/features"
        , glue = {"com.homedepot"}
        , tags= " @Login"
        , dryRun = false
        )


public class TestRunner {

}
