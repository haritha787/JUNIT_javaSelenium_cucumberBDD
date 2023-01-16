package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//reports-html,(juint) xml, json, junit, extent
@CucumberOptions(features="src/test/java/Features",
                 glue="stepDefinitions",dryRun=false,monochrome=true,
                			plugin = {"pretty","html:target/html/cucumber.html","json:target/json/cucumber.json",
                					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"},tags ="@SearchOffer")

public class testNGRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}
