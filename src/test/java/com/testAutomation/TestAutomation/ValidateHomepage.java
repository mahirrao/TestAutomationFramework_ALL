package com.testAutomation.TestAutomation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class ValidateHomepage extends base
{
	@BeforeTest	
	private void initializeTest() throws IOException
	{
		driver = initializeDriver();
		
		driver.get(prop.getProperty("URL"));
	}	
	
	@Test
	public void validateHomePage() throws IOException
	{

		
		LandingPage landPage = new LandingPage(driver);
		
		Assert.assertEquals(landPage.getSectionTitle(driver).getText(),"FEATURED COURSES");
		Assert.assertTrue(landPage.getSectionTitle(driver).isDisplayed());
		
	}

	@AfterTest
	private void terminateDriver()
	{
		driver.close();
	}
	
}
