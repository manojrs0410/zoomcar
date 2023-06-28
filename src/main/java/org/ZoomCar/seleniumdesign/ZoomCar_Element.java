package org.ZoomCar.seleniumdesign;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface ZoomCar_Element {
	
	public void click (WebElement element, String desc);
	
	public void enterText (WebElement element, String data);
	
	public void mouseHover (WebElement element);
	
	public void startAndEndSlider(WebElement elementStart, WebElement elementEnd);
	
	public void secondLocation(List<WebElement> element);
	
	public String newlyAddedCars(List<WebElement> elements);
	
	public void highRatedCar(List<WebElement> element);
	
	public void listOfImages(List<WebElement> element);
	
}
