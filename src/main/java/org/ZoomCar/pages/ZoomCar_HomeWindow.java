package org.ZoomCar.pages;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ZoomCar.testngbase.ZoomCar_TestNg_Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZoomCar_HomeWindow extends ZoomCar_TestNg_Base {
	

	
	public ZoomCar_HomeWindow(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH , using= "//section[@class='location-calendar-tab'][1]") private WebElement mouseHoveringLocation;
	@FindBy (how=How.XPATH , using= "//section[@class='location-list-items']//child::section[@class='location-list-items-item']") private List<WebElement> clickLocation;
	@FindBy(how=How.XPATH , using= "((//section[@class='calendar-v2-month'])[2]//div[@class='calendar-v2-month-dates-week-day'])[8]") private WebElement startDate;
	@FindBy (how=How.XPATH , using= "((//section[@class='calendar-v2-month'])[2]//div[@class='calendar-v2-month-dates-week-day'])[11]") private WebElement endDate;
	@FindBy(how=How.XPATH , using= "(//div[@class='component-time-slider time-wrap'])[1]//span[@class='text']") private WebElement startSlider;
	@FindBy (how=How.XPATH , using= "(//div[@class='component-time-slider time-wrap'])[2]//span[@class='text']") private WebElement endSlider;
	@FindBy (how=How.XPATH , using= "//div[@class='calendar-v2-time-slider-button-submit-button']") private WebElement searchButton;
	@FindBy(how=How.XPATH , using= "//div[text()='Best rated']") private WebElement bestRated;
	@FindBy (how=How.XPATH , using= "//div[text()='Petrol']") private WebElement petrol;
	@FindBy(how=How.XPATH , using= "//div[text()='FASTag']") private WebElement fastTag;
	@FindBy (how=How.XPATH , using= "//div[contains(@class,'tag new')]/../..//following-sibling::section[contains(@class,'car-info')]/section[contains(@class,'info-title')]") private List<WebElement> addedCars;
	@FindBy(how=How.XPATH , using= "//section[contains(@class,'action-rating-text') and not(contains(text(),'Not Yet Rated'))]") private List<WebElement> topRated;
	@FindBy(how=How.XPATH , using= "//section[@class='car-item-search-container-image-container-action-rating-text']") private List<WebElement> clickRatedCar;
	@FindBy (how=How.XPATH , using= "(//div[@class='carousal-list'])[1]//child::div[@class='carousal-list-image-container']") private List<WebElement> listImages;
//	@FindBy (how=How.XPATH , using= "//img[contains(@src, 'right-arrow')]") private WebElement clickImage;
		
	
	
	public ZoomCar_HomeWindow mouseHoverLocation() {
		mouseHover(mouseHoveringLocation);		
		return this;
	}
	
	public ZoomCar_HomeWindow clickSecondLocation() {
		secondLocation(clickLocation);
		return this;
	}
	
	public ZoomCar_HomeWindow clickStartDateOfNextMonth() {
		click(startDate, " next month Start Date");
		return this;
	}
	
	public ZoomCar_HomeWindow clickEndDateOfNextMonth() {
		click(endDate, " next month End Date");
		return this;
	}
	
	public ZoomCar_HomeWindow moveStartAndEndSlider() {
		startAndEndSlider(startSlider, endSlider);
		return this;
		}
	
	public ZoomCar_HomeWindow clickSearchButton() {
		click(searchButton, " Search button");
		return this;
	}
	
	public ZoomCar_HomeWindow clickBestRated() {
		click(bestRated, " Best Rated button");
		return this;
	}
	
	public ZoomCar_HomeWindow clickFuelTypePetrol() {
		click(petrol, " Petrol button");
		return this;
	}
	
	public ZoomCar_HomeWindow clickFastTag() throws InterruptedException {
		click(fastTag, " FastTag button");
		Thread.sleep(3000);
		return this;
	}
	
	public ZoomCar_HomeWindow printNewlyAddedCarNames() {
		newlyAddedCars(addedCars);
		return this;
	}
	
	public ZoomCar_HomeWindow selectMaxUserRatingCar() throws InterruptedException {
		Thread.sleep(3000);
		highRatedCar(topRated);
		return this;
		
	}
    
	public ZoomCar_HomeWindow clickImageNavigationButton() throws InterruptedException {
		listOfImages(listImages);
		return this;
	}

}
