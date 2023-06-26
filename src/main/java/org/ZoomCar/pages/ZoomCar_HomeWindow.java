package org.Amazon.pages;

import java.time.Duration;

import org.Amazon.testngbase.Amazon_TestNg_Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_HomeWindow extends Amazon_TestNg_Base {
	
	Actions action = new Actions(driver);


	public Amazon_HomeWindow(RemoteWebDriver driver) {
		System.out.println("Inside Constructor HomeWindow");
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH , using= "//input[@id='twotabsearchtextbox']") private WebElement enterMobile;
	@FindBy (how=How.XPATH , using= "//input[@id='twotabsearchtextbox']") private WebElement pressEnter;
	@FindBy (how=How.XPATH , using= "//div[@class='a-section aok-relative s-image-fixed-height']//child::img[@class='s-image' and @alt='(Renewed) OnePlus 9 Pro 5G (Pine Green, 12GB RAM, 256GB Storage)']") private WebElement clickMobile;	
	
	
	public Amazon_HomeWindow enterMobileName() {
		//Thread.sleep(4000);
		System.out.println("Enter in textbox");
		enterText(enterMobile, "oneplus 9 pro mobiles");
		return this;
	}
	
	public Amazon_HomeWindow pressEnterKey() {
		//Thread.sleep(4000);
		System.out.println("Press Enter Key");
		enterKey(pressEnter);
		return this;
	}
	
	public Amazon_ChildWindow clickFirstMobileImage() {
		click(clickMobile);
		return new Amazon_ChildWindow(driver);
	}
	
	
	
	

}
