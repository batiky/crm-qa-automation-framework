package com.maximus.crm.runners;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty",
				"html:target/cucumber-report",
				"json:target/cucumber.json"
		},
		tags = "@regression",
		features = {"src/test/resources/com/maximus/crm/features"},
		glue = "com/maximus/crm/step_definitions",
		dryRun= false
		)
public class RegressionRunner {

}
