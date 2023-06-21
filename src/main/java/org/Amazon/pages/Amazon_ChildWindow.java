package org.Amazon.pages;

import java.time.Duration;

import org.Amazon.testngbase.Amazon_TestNg_Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_ChildWindow extends Amazon_TestNg_Base {
	
	public Amazon_ChildWindow (RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='vendorTaxId']") private WebElement enterVendorTaxID;
	@FindBy(how=How.XPATH , using = "//input[@id='name']") private WebElement enterName;
	@FindBy(how=How.XPATH , using = "//input[@id='address']") private WebElement enterAddress;
	@FindBy(how=How.XPATH , using = "//input[@id='city']") private WebElement enterCity;
	@FindBy(how=How.XPATH , using = "//input[@id='country']") private WebElement enterCountry;
	@FindBy(how=How.XPATH , using = "//button[text()='Save Vendor']") private WebElement clickSaveVendor;
	@FindBy(how=How.XPATH , using = "//a[text()='Log Out']") private WebElement clickonLogOut;
	
	public Amazon_ChildWindow enterAddVendorDetails() {
		enterText(enterVendorTaxID, "ID01");
		enterText(enterName, "Manojkumar");
		enterText(enterAddress, "North Street");
		enterText(enterCity, "Chennai");
		enterText(enterCountry, "India");		
		return this;
	}
	
	public Amazon_ChildWindow saveVendor() {
		click(clickSaveVendor);
		return this;
	}
	
	public Amazon_ChildWindow promptWindow() throws InterruptedException {
		System.out.println("Alert");
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.alertIsPresent());
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		return this;
	}
	
	public Amazon_ChildWindow clickLogout() {
		click(clickonLogOut);
		return this;
	}
	
	
}
