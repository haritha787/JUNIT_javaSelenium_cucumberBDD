package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//reports-html,(juint) xml, json, junit, extent
@CucumberOptions(features="@target/failed_scenarios.txt",
		         glue="stepDefinitions",dryRun=false,monochrome=true,
		        			plugin = {"pretty","html:target/html/cucumber.html","json:target/json/cucumber.json",
		        					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class failedTestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}

