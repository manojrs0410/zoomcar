package org.ZoomCar.seleniumdesign;

import org.openqa.selenium.WebElement;

public interface ZoomCar_Element {
	
	public void click (WebElement element);
	
	public void enterKey (WebElement element);
	
	public void enterText (WebElement element, String data);
	
	public void mouseOver (WebElement element);
	
}
