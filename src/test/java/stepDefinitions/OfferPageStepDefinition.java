package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContext;

public class OfferPageStepDefinition {

public String OfferPageproductName;

public TestContext driverLink;
public PageObjectManager pageObjectManager;

//single responsibility principle -loosely coupled classes and methods for offer page
//FactoryDesignPattern - assign responsibility to single class for all object declaration in constructor
public OfferPageStepDefinition (TestContext testContext)
{
	this.driverLink = testContext;
}




	@Then("^User searched for same product shortname (.+) in offers page and check if the product exists$")
	public void user_searched_for_same_product_shortname_in_offers_page_and_check_if_the_product_exists(String shortname) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		OffersPage offerspage = driverLink.pageObjectManager.getOffersPageObject();
		switch_to_offers_page();
		offerspage.searchItem(shortname);
		Thread.sleep(2000);
		OfferPageproductName = offerspage.getProductName();		
		compareProductNames();		
		
	}

	public void switch_to_offers_page()
	{
		
		LandingPage landingpage = driverLink.pageObjectManager.getLandingPageObject();
		landingpage.selectTopDeals();
		driverLink.genericUtils.SwitchWindowToChild();
	 
	}
	
	public void compareProductNames()
	{
		Assert.assertEquals(driverLink.LandingPageproductName, OfferPageproductName);
	 
	}


}
