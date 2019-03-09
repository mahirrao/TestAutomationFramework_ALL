package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebDriver driver;
	
	By userName = By.id("user_email");
	By password = By.cssSelector("input[id*='user_password']");
	By loginButton = By.xpath("//input[@value='Log In']");
	
	public WebElement getUsername(WebDriver driver)
	{
		return driver.findElement(userName);		
	}
	
	public WebElement getPassword(WebDriver driver)
	{
		return driver.findElement(password);			
	}
	
	public WebElement getLogInButton(WebDriver driver)
	{
		return driver.findElement(loginButton);		
	}


}
