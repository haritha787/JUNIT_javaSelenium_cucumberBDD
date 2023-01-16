package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

		public WebDriver driver;
		
		public OffersPage(WebDriver driver)
		{
			this.driver = driver;
		}
		
		
		By searchField = By.xpath("//input[@id='search-field']");		
		By productName = By.xpath("//div[@id='root']/div/div/div/div/div/div/table/tbody/tr/td");
		
		public void searchItem(String name)
		{
			driver.findElement(searchField).sendKeys(name);
		}


		public String getProductName()
		{
			return driver.findElement(productName).getText();
		}
	

}