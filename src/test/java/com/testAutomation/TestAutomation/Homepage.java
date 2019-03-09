package com.testAutomation.TestAutomation;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class Homepage extends base
{
	@Test
	public void homePageNavigation() throws IOException
	{
		driver = initializeDriver();
		prop=getProperties();
		
		String url = prop.getProperty("URL");
		String userName = prop.getProperty("userName");
		String password = prop.getProperty("password");
		
		driver.get(url);
		
		LandingPage landPage = new LandingPage(driver);
		landPage.getLogIn(driver).click();
		
		LoginPage logPage = new LoginPage(driver);
		logPage.getUsername(driver).sendKeys(userName);
		logPage.getPassword(driver).sendKeys(password);
		logPage.getLogInButton(driver).click();
		
		driver.close();
	}

}
