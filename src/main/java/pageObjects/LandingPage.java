package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage
{
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebDriver driver;
	
	By signIn = By.cssSelector("a[href *= 'sign_in']");
	
	public WebElement getLogIn(WebDriver driver)
	{		
		return driver.findElement(signIn);
	}
}
