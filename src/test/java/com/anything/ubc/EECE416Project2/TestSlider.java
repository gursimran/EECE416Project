package com.anything.ubc.EECE416Project2;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestSlider {
	private String baseUrl;
	private WebDriver driver;

	public TestSlider(String baseUrl, WebDriver driver) {
		this.baseUrl = baseUrl;
		this.driver = driver;
	}
	
	public boolean PerfoemTestSlider(){
		WebElement slider = driver.findElement(By.cssSelector("div[id^=\"slider\"]"));
		 List<WebElement> images = slider.findElements(By.tagName("img"));
		 Actions builder = new Actions(driver); 
		 Actions hoverOverRegistrar = builder.moveToElement(slider);
		 hoverOverRegistrar.perform();
		 WebElement next = slider.findElement(By.cssSelector("div[class^=\"nivo-directionNav\"] > a[class^=\"nivo-nextNav\"]"));
		 
		 for (int i = 0; i < images.size() ; i++){
			 next.click();
			 try {
				 	String imageUrl = images.get((i+1)%5).getAttribute("src").substring(27);
				 	Thread.sleep(1000);
				 	WebElement imageDisplayed = slider.findElement(By.className("nivo-slice"));
				    if(!imageDisplayed.getAttribute("style").contains(imageUrl)){
				    	return(false);
				    }
				    
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			 
		 }
		 return(true);
	}
}
