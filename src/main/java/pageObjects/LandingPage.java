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
	By sectionTitle = By.cssSelector("section[id='content'] div div h2");
	By headerSection = By.cssSelector("ul.nav navbar-nav navbar-right");
	
	public WebElement getLogIn(WebDriver driver)
	{		
		return driver.findElement(signIn);
	}
	
	public WebElement getSectionTitle(WebDriver driver)
	{		
		return driver.findElement(sectionTitle);
	}
	
	public WebElement getHeaderSection(WebDriver driver)
	{		
		return driver.findElement(headerSection);
	}
}
