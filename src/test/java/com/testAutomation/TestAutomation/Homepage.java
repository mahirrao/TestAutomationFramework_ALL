package com.testAutomation.TestAutomation;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class Homepage extends base
{
	@Test(dataProvider="getData")
	public void homePageNavigation(String userName, String password) throws IOException
	{
		driver = initializeDriver();
		prop=getProperties();
		
		String url = prop.getProperty("URL");
		
		driver.get(url);
		
		LandingPage landPage = new LandingPage(driver);
		landPage.getLogIn(driver).click();
		
		LoginPage logPage = new LoginPage(driver);
		logPage.getUsername(driver).sendKeys(userName);
		logPage.getPassword(driver).sendKeys(password);
		logPage.getLogInButton(driver).click();
		
		driver.close();
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
