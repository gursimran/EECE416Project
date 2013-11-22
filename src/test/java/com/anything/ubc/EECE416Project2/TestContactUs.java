package com.anything.ubc.EECE416Project2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestContactUs {
	private String baseUrl = Data.getUrl(3);
	 private WebDriver driver;
	 
	 @Before
	  public void openBrowser() {
		  driver = new FirefoxDriver();
	      driver.get(baseUrl);
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
	 
	 @Test
	 public void TestFooter(){
		 TestFooter testFooter = new TestFooter(driver.getCurrentUrl(), driver);
		 boolean result = testFooter.PerformTestFooter();
		 assertEquals(true, result);
	 }
	 
	 @Test
	 public void TestHeaderImage(){ 
		 WebElement image = driver.findElement(By.cssSelector("div[id^=\"header\"] > a > img"));
		 assertTrue(TestImage(image));
	 }
	 
	 
	 @Test
	 public void TestSlider(){
		 TestSlider slider = new TestSlider(baseUrl, driver);
		 assertTrue(slider.PerfoemTestSlider());
	 }
	 
	 @Test
	 public void TestContentImage(){
		 WebElement image = driver.findElement(By.cssSelector("div[class^=\"contactimages\"] > img"));
		 assertTrue(TestImage(image));
	 }
	 
	 @Test 
	 public void GoogleMapsURL(){
		 WebElement link = driver.findElement(By.cssSelector("div[class^=\"contactimages\"] > small > a"));
		 link.click();
		 assertEquals(driver.getCurrentUrl(), Data.getUrl(6));
	 }
	 
	 private Boolean TestImage(WebElement image){
		 Object result = ((JavascriptExecutor) driver).executeScript(
		          "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);

		             boolean loaded = false;
		    if(result instanceof Boolean){
		    	loaded = (Boolean) result;
		    	return(loaded);
		    }
		    return false;
	 }
}
