package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContext;

public class CheckoutPageStepDefinition {

	public TestContext driverLink;
	public WebDriver driver;
	public String CheckOutPageproductName;
	public CheckoutPage checkoutPage;
	    public CheckoutPageStepDefinition (TestContext testContext)
	    {
	    	this.driverLink = testContext;
	    	this.checkoutPage = driverLink.pageObjectManager.getCheckOutPageObject();
	    }
	    
	
	@Then("User checked if the product exists")
	public void user_checked_if_the_product_exists() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		CheckoutPage checkoutPage = driverLink.pageObjectManager.getCheckOutPageObject();
		CheckOutPageproductName = checkoutPage.getProductName().split("-")[0].trim();
		checkifProductExists();
	}
	
	public void checkifProductExists() throws InterruptedException
	{
		Assert.assertEquals(driverLink.LandingPageproductName, CheckOutPageproductName);
		Thread.sleep(2000);
	}
	
	@And("User checked if Apply button and Place Order buttons exists")
	public void user_checked_if_apply_button_and_place_order_buttons_exists() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	
		
		//Assert.assertEquals("Apply", checkoutPage.getApplyButtonName());
		//Assert.assertEquals("Place Order", checkoutPage.getPlaceOrderButtonName());
		System.out.println(checkoutPage.getApplyButtonExists());
		Assert.assertTrue(checkoutPage.getApplyButtonExists());
		
		System.out.println(checkoutPage.getPlaceOrderButtonExists());
		Assert.assertTrue(checkoutPage.getPlaceOrderButtonExists());
		
		
				
	}
	


}
