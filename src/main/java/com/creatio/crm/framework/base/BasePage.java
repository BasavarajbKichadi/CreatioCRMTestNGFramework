package com.creatio.crm.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasePage {

	// This class will have all the common methods related to browser configurations related to browser and begin test execution

	private static WebDriver driver = null;

	// Common method to launch the browser
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "BROWSER" })
	public void setupBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (browserName.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		else if (browserName.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else
			Assert.fail("Invalid browser name");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	// Common method to close the browser
	@AfterMethod(alwaysRun = true)
	public void tearDownBrowser() {
		driver.quit();
	}
	
	// method to get the browser into other classes
	public WebDriver getDriver() {
		return driver;
	}	
	
	// method to set the new browser into other classes
	public void setDriver(WebDriver newDriver) {
		driver = newDriver;
	}

}
