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
public class TestFooter {
	 private String baseUrl;
	 private WebDriver driver;
	 
	 public TestFooter(String baseUrl, WebDriver driver){
		 this.baseUrl = baseUrl;
		 this.driver = driver;
	 }
	
	 public boolean PerformTestFooter(){
		 if (AboutUsTest()){
			 driver.get(baseUrl);
			 if (MenuTest()){
				 driver.get(baseUrl);
				 if(ServicesTest()){
					 driver.get(baseUrl);
					 if(ContactTest()){
						 driver.get(baseUrl);
						 if(FacebookTest()){
							 driver.get(baseUrl);
							 return true;
						 }
					 }
				 }
			 }
		 }
		 driver.get(baseUrl);
		 return false;
	 }
	 
	 private boolean AboutUsTest(){
		 List<WebElement> cheeses = driver.findElements(By.cssSelector("div[class^=\"footnav\"] > a"));
		 WebElement temp=cheeses.get(0);
		 temp.click();
		 return (driver.getCurrentUrl().equals(Data.getUrl(0)));
	 }
	 
	 private boolean MenuTest(){
		 List<WebElement> cheeses = driver.findElements(By.cssSelector("div[class^=\"footnav\"] > a"));
		 WebElement temp=cheeses.get(1);
		 temp.click();
		 return (driver.getCurrentUrl().equals(Data.getUrl(1)));
	 }
	 
	 private boolean ServicesTest(){
		 List<WebElement> cheeses = driver.findElements(By.cssSelector("div[class^=\"footnav\"] > a"));
		 WebElement temp=cheeses.get(2);
		 temp.click();
		 return (driver.getCurrentUrl().equals(Data.getUrl(2)));
	 }
	 

	 private boolean ContactTest(){
		 List<WebElement> cheeses = driver.findElements(By.cssSelector("div[class^=\"footnav\"] > a"));
		 WebElement temp=cheeses.get(3);
		 temp.click();
		 return (driver.getCurrentUrl().equals(Data.getUrl(3)));
	 }	
	 
	 private boolean FacebookTest(){
		 WebElement facebook = driver.findElement(By.cssSelector("div[class^=\"facebook\"] > a"));
		 facebook.click();
		 return (driver.getCurrentUrl().equals(Data.getUrl(5)));
	 }
}
