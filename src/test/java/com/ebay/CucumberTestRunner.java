package com.ebay;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.ebay.steps"},
        format = {"pretty", "html:report"},
        features = "src/test/resources"
)
public class CucumberTestRunner {

}
