package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public LandingPage landingpage;
	public OffersPage offerspage;
	public CheckoutPage checkoutPage;
	public WebDriver driver;
	
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LandingPage getLandingPageObject()
	{
		landingpage = new LandingPage(driver);
		return landingpage;
		
	}
	
	public OffersPage getOffersPageObject()
	{
		offerspage = new OffersPage(driver);
		return offerspage;	
	}
	
	
	public CheckoutPage getCheckOutPageObject()
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;	
	}
	
	
}
