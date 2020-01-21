package com.homedepot;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features"
        , tags= "@invalid_login"
        , dryRun = true
        )


public class TestRunner {

}
