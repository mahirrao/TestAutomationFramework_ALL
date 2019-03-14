package com.testAutomation.TestAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class Homepage extends base
{
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	private void initializeTest() throws IOException
	{
		log.info("Executing the test: " +this.getClass().getName());
		driver = initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void homePageNavigation(String userName, String password) throws IOException
	{
		log.info("In the method: " +new Throwable().getStackTrace()[0].getMethodName());
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to Landing Page");
		
		LandingPage landPage = new LandingPage(driver);
		landPage.getLogIn(driver).click();
		log.info("Navigated to Login Page");
		
		LoginPage logPage = new LoginPage(driver);
		logPage.getUsername(driver).sendKeys(userName);
		logPage.getPassword(driver).sendKeys(password);
		logPage.getLogInButton(driver).click();		
		Assert.assertFalse(logPage.isInvalidLogin(driver));
		
		log.info("Tried to Log In");
		
	}

	@AfterTest
	private void terminateDriver()
	{
		driver.close();
		driver = null;
		log.info("Execution complete for the test: " +this.getClass().getName());
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Number of Rows : The number of data sets present;
		//number of time a testshould run
		//Number of Columns : Number of values needed in a single test run 
		Object[][] data = new Object[2][2];
		
		//0th row (First Dataset)
		data[0][0] = "md.ahirrao@gmail.com";
		data[0][1] = "Mayur3108";
		
		//1st row (Second Dataset)
		data[1][0] = "abc@gmail.com";
		data[1][1] = "def";
		
		return data;
	}

}
