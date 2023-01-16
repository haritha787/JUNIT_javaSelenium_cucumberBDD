package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//reports-html,(juint) xml, json, junit, extent
@RunWith(Cucumber.class)
@CucumberOptions(features="@target/failed_scenarios.txt",
		         glue="stepDefinitions",dryRun=false,monochrome=true,
		        			plugin = {"pretty","html:target/html/cucumber.html","json:target/json/cucumber.json",
		        					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class failedTestRunner{

}

