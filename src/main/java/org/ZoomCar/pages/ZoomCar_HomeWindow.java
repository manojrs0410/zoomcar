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
	
	Actions action = new Actions(driver);
	
	public ZoomCar_HomeWindow(RemoteWebDriver driver) {
		System.out.println("Inside Constructor HomeWindow");
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH , using= "//section[@class='location-calendar-tab'][1]") private WebElement mouseHover;
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
	@FindBy (how=How.XPATH , using= "//img[contains(@src, 'right-arrow')]") private WebElement clickImage;
		
	
	
	public ZoomCar_HomeWindow mouseHoverLocation() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf (mouseHover));
		System.out.println("Entered into the textbox");
		action.moveToElement(mouseHover).perform();
		return this;
	}
	
	public ZoomCar_HomeWindow clickSecondLocation() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Clicked the 2nd Location");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
        if (clickLocation.size() > 1) {
            WebElement secondLocation = clickLocation.get(1);
            secondLocation.click();
        }
		return this;
	}
	
	public ZoomCar_HomeWindow clickStartDateOfNextMonth() {
		click(startDate);
		return this;
	}
	
	public ZoomCar_HomeWindow clickEndDateOfNextMonth() {
		click(endDate);
		return this;
	}
	
	public ZoomCar_HomeWindow moveStartDateSlider() throws InterruptedException {
		System.out.println("In Start Date Slider");
		Thread.sleep(5000);
		String time = startSlider.getText();
		System.out.println("Start Time: "+time);
		action.clickAndHold((WebElement) startSlider);
		action.moveByOffset(-130, 0).release().build().perform();
		return this;
		}
	

	public ZoomCar_HomeWindow moveEndDateSlider() throws InterruptedException {
		System.out.println("In End Date Slider");
		Thread.sleep(5000);
		String time = endSlider.getText();
		System.out.println("Start Time: "+time);
		action.clickAndHold((WebElement) endSlider);
		action.moveByOffset(100, 0).release().build().perform();
		return this;
	}

	
	public ZoomCar_HomeWindow clickSearchButton() throws InterruptedException {
		Thread.sleep(2000);
		click(searchButton);
		System.out.println("Clicked Search button");
		return this;
	}
	
	public ZoomCar_HomeWindow clickBestRated() throws InterruptedException {
		Thread.sleep(2000);
		click(bestRated);
		System.out.println("Clicked Best Rated from Sort By field");
		return this;
	}
	
	public ZoomCar_HomeWindow clickFuelTypePetrol() throws InterruptedException {
		Thread.sleep(2000);
		click(petrol);
		System.out.println("Clicked Petrol from Fuel Type field");
		return this;
	}
	
	public ZoomCar_HomeWindow clickFastTag() throws InterruptedException {
		Thread.sleep(2000);
		click(fastTag);
		System.out.println("Clicked FastTag from Add-ons field");
		return this;
	}
	
	public ZoomCar_HomeWindow printNewlyAddedCarNames() throws InterruptedException {
		Thread.sleep(2000);
        for (WebElement carNames : addedCars) {
            System.out.println(carNames.getText());
        }
		return this;
	}
	
    public ZoomCar_HomeWindow selectMaxUserRatingCar() {
        double maxRating = -1;
        int maxIndex = -1;
        for (int i = 0; i < topRated.size(); i++) {
        	try {
        	String ratingString[] = topRated.get(i).getText().trim().split(" ");
        	Float ratingText = Float.parseFloat(ratingString[0]);
            double rating = ratingText.doubleValue();
            if (rating > maxRating) {
                maxRating = rating;
                maxIndex = i;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (maxIndex != -1) {
            WebElement maxRatingCar = topRated.get(maxIndex);
            click(maxRatingCar);
        }

    }
		return this;
    }
    
	public ZoomCar_HomeWindow clickImageNavigationButton() throws InterruptedException {
		Thread.sleep(2000);
		for(int i=0;i<2;i++) {
	            click(clickImage);
	        }
		return this;
	}

}
