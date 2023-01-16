package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By search = By.cssSelector("input.search-keyword");
	By topDeals = By.linkText("Top Deals");
	By productName = By.cssSelector("h4.product-name");
	
	By addToCart_button = By.cssSelector("div.product-action > button[type=\"button\"]");
	By increment_button = By.cssSelector("a.increment");
	By proceedToCheckOut_button = By.xpath("(//div[@class='action-block']/button)[1]");
	By shoppingCart_button = By.xpath("//a[@class='cart-icon']/img");
	
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}

	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDeals()
	{
		 driver.findElement(topDeals).click();
	}
	
	public void incrementMoreProducts(int number)
	{
		for(int i= 0;i<number;i++)
		{
			driver.findElement(increment_button).click();
		}
		 
	}
	
	public void addToCart()
	{
		 driver.findElement(addToCart_button).click();
	}
	
	public void goToShoppingCart()
	{
		 driver.findElement(shoppingCart_button).click();
	}
	
	public void proceedToCheckOut()
	{
		 driver.findElement(proceedToCheckOut_button).click();
	}
	
	public String getTitleLandingPage()
	{
		 return driver.getTitle();
	}
	
}
