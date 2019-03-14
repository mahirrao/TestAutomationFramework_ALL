package com.testAutomation.TestAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base
{
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = getProperties();
		String browserName = prop.getProperty("browser");
		log.info("browser Name is: " +browserName);
		
		if (browserName.equalsIgnoreCase("IE"))
		{
			System.out.println("Launching IE");
			System.setProperty("webdriver.ie.driver", ".\\src\\main\\java\\drivers\\IEDriverServer3_14.exe");
			driver = new InternetExplorerDriver();

		}else 
		if (browserName.equalsIgnoreCase("Firefox"))
		{
			System.out.println("Launching Firefox");
			System.setProperty("webdriver.gecko.driver", ".\\src\\main\\java\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}else
		if (browserName.equalsIgnoreCase("Chrome"))
		{
			System.out.println("Launching Chrome");
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\java\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

	public Properties getProperties() throws FileNotFoundException, IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\src\\main\\java\\properties\\data.properties");
		prop.load(fis);
		return prop;
	}
	
	public void takeScreenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\Screenshots\\"+result+".png"));
	}
	

}
