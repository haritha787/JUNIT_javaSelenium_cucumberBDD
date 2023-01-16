package stepDefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestBase;
import utils.TestContext;

//single responsibility principle -loosely coupled classes for landing page
public class LandingPageStepDefinition {

public TestContext driverLink;
public WebDriver driver;
public LandingPage landingpage;
    public LandingPageStepDefinition (TestContext testContext)
    {
    	this.driverLink = testContext;
    	this.landingpage = driverLink.pageObjectManager.getLandingPageObject();
    }
	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driverLink.testBase.WebDriverManager();
		System.out.println(landingpage.getTitleLandingPage() + "is title in homepage");
		
		Assert.assertTrue(landingpage.getTitleLandingPage().contains("GreenKart - veg and fruits kart"));		

	}
	
	@When("^User searched with product shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_product_shortname_and_extracted_actual_name_of_the_product(String shortname) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		landingpage.searchItem(shortname);
		Thread.sleep(2000);
		driverLink.LandingPageproductName = landingpage.getProductName().split("-")[0].trim();
		System.out.println(driverLink.LandingPageproductName + "is extracted in homepage");
	   
	}

	@When("User added {int} more product")
	public void user_added_more_product(Integer additionalItems) {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage landingpage = driverLink.pageObjectManager.getLandingPageObject();
		landingpage.incrementMoreProducts(additionalItems);
	    
	}
	@Then("User added product to cart and checked out the product")
	public void user_added_product_to_cart_and_checked_out_the_product() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage landingpage = driverLink.pageObjectManager.getLandingPageObject();
		landingpage.addToCart();	
		checkOutProduct();
	}
	
	public void checkOutProduct() throws InterruptedException
	{
		LandingPage landingpage = driverLink.pageObjectManager.getLandingPageObject();		
		landingpage.goToShoppingCart();		
		landingpage.proceedToCheckOut();
		
	}
	
}
