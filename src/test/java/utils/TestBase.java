package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public WebDriver driver;
		
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAurl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		//result = testCondition ? value1 : value2
		String browser = browser_maven!=null ? browser_maven : browser_properties;
				
		if(driver == null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			    System.setProperty("webdriver.chromedriver.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver");
			    
			}
			if(browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			    System.setProperty("webdriver.gecko.driver", "//User//hchandrasekaran//Documents//Firefox//geckodriver");
				
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		    driver.get(url);	
		    System.out.println("I gave driver WHEN null");
		}
		System.out.println("I gave driver not null");
	    return driver;
	    
	}

}
