package com.anything.ubc.EECE416Project2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Unit test for simple App.
 */
public class TestNav {
	 private String baseUrl;
	 private WebDriver driver;
	 
	 public TestNav(String baseUrl, WebDriver driver){
		 this.baseUrl = baseUrl;
		 this.driver = driver;
	 }
	
	 public boolean PerformTestNav(){
		 if (AboutUsTest()){
			 driver.get(baseUrl);
			 if (MenuTest()){
				 driver.get(baseUrl);
				 if(ServicesTest()){
					 driver.get(baseUrl);
					 if(ContactTest()){
						 driver.get(baseUrl);
						 return true;
					 }
				 }
			 }
		 }
		 driver.get(baseUrl);
		 return false;
	 }
	 
	 private boolean AboutUsTest(){
		 List<WebElement> cheeses = driver.findElements(By.cssSelector("div[id^=\"menu\"] >ul>li"));
		 WebElement temp=cheeses.get(0).findElement(By.tagName("a"));
		 temp.click();
		 return (driver.getCurrentUrl().equals("http://broadmoorbakery.com/index.html#"));
	 }
	 
	 private boolean MenuTest(){
		 List<WebElement> cheeses = driver.findElements(By.cssSelector("div[id^=\"menu\"] >ul>li"));
		 WebElement temp=cheeses.get(1).findElement(By.tagName("a"));
		 temp.click();
		 return (driver.getCurrentUrl().equals("http://broadmoorbakery.com/menu.html"));
	 }
	 
	 private boolean ServicesTest(){
		 List<WebElement> cheeses = driver.findElements(By.cssSelector("div[id^=\"menu\"] >ul>li"));
		 WebElement temp=cheeses.get(2).findElement(By.tagName("a"));
		 temp.click();
		 return (driver.getCurrentUrl().equals("http://broadmoorbakery.com/services.html"));
	 }
	 

	 private boolean ContactTest(){
		 List<WebElement> cheeses = driver.findElements(By.cssSelector("div[id^=\"menu\"] >ul>li"));
		 WebElement temp=cheeses.get(3).findElement(By.tagName("a"));
		 temp.click();
		 return (driver.getCurrentUrl().equals("http://broadmoorbakery.com/contact.html"));
	 }	
}
