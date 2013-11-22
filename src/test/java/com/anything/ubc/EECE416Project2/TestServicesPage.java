package com.anything.ubc.EECE416Project2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestServicesPage {
	private String baseUrl = Data.getUrl(2);
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
		 WebElement image = driver.findElement(By.cssSelector("div[id^=\"about\"] > img"));
		 assertTrue(TestImage(image));
	 }
	 
	 @Test
	 public void TestEnlargeCakes(){
		 List<WebElement> cakeImages = driver.findElements(By.cssSelector("div[id^=\"cakes\"] > a > img"));
		 for(int i=0; i<cakeImages.size(); i++){
			 if(!TestImage(cakeImages.get(i))){
				 assertTrue(false);
			 }
			 if (!TestWrapperImage(i)){
				 assertTrue(false);
			 }
		 }
		 assertTrue(true);
	 }
	 
	 
	 private boolean TestWrapperImage(int imageToTest){
		 List<WebElement> cakeImages = driver.findElements(By.cssSelector("div[id^=\"cakes\"] > a"));
		 cakeImages.get(imageToTest).click();
		 try {
			Thread.sleep(3000);
			WebElement enlargeImage = driver.findElement(By.cssSelector("div[id^=\"sb-body-inner\"] > img"));
			if(!TestImage(enlargeImage)){
				return false;
			}
			WebElement close = driver.findElement(By.cssSelector("div[id^=\"sb-nav\"] > a"));
			close.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			return false;
		}
		return true; 
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
