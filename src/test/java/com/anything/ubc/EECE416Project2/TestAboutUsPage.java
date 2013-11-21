package com.anything.ubc.EECE416Project2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAboutUsPage {

	private String baseUrl;
	 private WebDriver driver;
	 
	 @Before
	  public void openBrowser() {
		  driver = new FirefoxDriver();
	      driver.get("http://broadmoorbakery.com/");
	  }
	 
	 @After
	 public void closeBrowser(){
		 driver.close();
	 }
	
	 @Test
	public void TestNavBar() {
		 TestNav testNav = new TestNav(driver.getCurrentUrl(), driver);
		 boolean result = testNav.PerformTestNav();
		 assertEquals(true, result);
	 }

}
