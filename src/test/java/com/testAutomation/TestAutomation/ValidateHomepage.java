package com.testAutomation.TestAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class ValidateHomepage extends base
{
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest	
	private void initializeTest() throws IOException
	{
		log.info("Executing the test: " +this.getClass().getName());
		driver = initializeDriver();
		log.info("Driver is initialized");
	}	
	
	@Test
	public void validateHomePage() throws IOException
	{
		log.info("In the method: " +new Throwable().getStackTrace()[0].getMethodName());
				
		driver.get(prop.getProperty("URL"));
		
		LandingPage landPage = new LandingPage(driver);
		
		Assert.assertEquals(landPage.getSectionTitle(driver).getText(),"FEATURED COURSES");
		log.info("Successfully validated the courses section text");
		Assert.assertTrue(landPage.getSectionTitle(driver).isDisplayed());
		log.info("Successfully validated the Section Title");
		
	}

	@AfterTest
	private void terminateDriver()
	{
		driver.close();
		driver = null;
		log.info("Execution complete for the test: " +this.getClass().getName());
	}
	
}
