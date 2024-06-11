package org.appiumdemo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/SampleTest.feature",
        glue = {"org.appiumdemo.stepdefs"}
)
public class TestRunner {
}
