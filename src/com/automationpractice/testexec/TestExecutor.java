package com.automationpractice.testexec;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue = {"com.automationpractice.stepdefinition"},
		plugin = {"html:target/html-report/Report"}
		)

public class TestExecutor {
	
}