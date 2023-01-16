package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.TestContext;

public class Hooks {

	public TestContext driverLink;

    public Hooks (TestContext testContext)
    {
    	this.driverLink = testContext;
    }
    
    
	@After
	public void AfterScenario() throws IOException, InterruptedException
	{
		driverLink.testBase.WebDriverManager().quit();
		Thread.sleep(2000);
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws WebDriverException, IOException
	{
		
		if(scenario.isFailed())
		{
			//screenshot
			File sourcepath = ((TakesScreenshot)driverLink.testBase.WebDriverManager()).getScreenshotAs(OutputType.FILE);
			byte[] fileinBytes = FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(fileinBytes, "image/png", "image");
		}
	}

}
