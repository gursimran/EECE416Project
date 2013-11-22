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

public class TestMenuPage {
	private String baseUrl = Data.getUrl(1);
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
	 public void TestCakesContent() throws InterruptedException{
		 assertTrue(TestConentImages());
		 assertTrue(TestSideBar(0));		 
	 }
	 
	 @Test
	 public void TestPiesContent() throws InterruptedException{
		 driver.get(Data.getMenuUrl(1));
		 assertTrue(TestConentImages());
		 assertTrue(TestSideBar(1));		 
	 }
	 
	 @Test
	 public void TestBreadsContent() throws InterruptedException{
		 driver.get(Data.getMenuUrl(2));
		 assertTrue(TestConentImages());
		 assertTrue(TestSideBar(2));		 
	 }
	 
	 @Test
	 public void TestPasteriesContent() throws InterruptedException{
		 driver.get(Data.getMenuUrl(3));
		 assertTrue(TestConentImages());
		 assertTrue(TestSideBar(3));		 
	 }
	 
	 @Test
	 public void TestCookiesContent() throws InterruptedException{
		 driver.get(Data.getMenuUrl(4));
		 assertTrue(TestConentImages());
		 assertTrue(TestSideBar(4));		 
	 }
	 
	 @Test
	 public void TestSavoriesContent() throws InterruptedException{
		 driver.get(Data.getMenuUrl(5));
		 assertTrue(TestConentImages());
		 assertTrue(TestSideBar(5));		 
	 }
	 
	 @Test
	 public void TestMiscContent() throws InterruptedException{
		 driver.get(Data.getMenuUrl(6));
		 assertTrue(TestConentImages());
		 assertTrue(TestSideBar(6));		 
	 }
	 
	 private Boolean TestSideBar(int sideBarItem) throws InterruptedException{
		 List<WebElement> sideBarItems = driver.findElements(By.cssSelector("div[class^=\"sidemenu\"] > ul > li"));
		 
		 if(!sideBarItems.get(sideBarItem).findElement(By.tagName("a")).getAttribute("class").equals("current")){
			 return false;
		 }
		 
		 for (int i=0; i<sideBarItems.size(); i++){
			 List<WebElement> images = driver.findElements(By.cssSelector("div[class^=\"sidemenu\"] > ul > li > a > img"));
			 if (!TestImage(images.get(i))){
				 return false;
			 }
			 List<WebElement> links = driver.findElements(By.cssSelector("div[class^=\"sidemenu\"] > ul > li > a"));
			 links.get(i).click();
			 if(!driver.getCurrentUrl().equals(Data.getMenuUrl(i))){
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 private Boolean TestConentImages(){
		 List<WebElement> image = driver.findElements(By.cssSelector("img[src^=\"images/polaroid/\"]"));
		 System.out.println(image.size());
		 for (int i =0; i < image.size(); i++){
			 if(!TestImage(image.get(i))){
				 return false;
			 }
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
