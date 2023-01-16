package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By apply_button = By.xpath("//div[@id='root']/div/div/div/div/div/button");
	By PlaceOrder_button = By.xpath("//button[contains(text(),'Place Order')]");
	By productName = By.cssSelector("p.product-name");
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public Boolean getApplyButtonExists()
	{
		return driver.findElement(apply_button).isDisplayed();
	}
	
	public Boolean getPlaceOrderButtonExists()
	{
		return driver.findElement(PlaceOrder_button).isDisplayed();
	}


	
	/*public Boolean getPromoCodeButtonName()
	{
		return driver.findElement(PlaceOrder_button);
	}*/

	
}
