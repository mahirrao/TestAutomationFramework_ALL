package com.testAutomation.TestAutomation;

import java.io.IOException;

import org.testng.annotations.Test;

public class Homepage extends base
{
	@Test
	public void homePageNavigation() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.amazon.co.in");
	}

}
