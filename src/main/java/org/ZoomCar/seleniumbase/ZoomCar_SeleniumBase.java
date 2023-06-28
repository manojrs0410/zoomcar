package org.ZoomCar.seleniumbase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.ZoomCar.pages.ZoomCar_HomeWindow;
import org.ZoomCar.seleniumdesign.ZoomCar_Browser;
import org.ZoomCar.seleniumdesign.ZoomCar_Element;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Reporter;

public class ZoomCar_SeleniumBase extends Reporter implements ZoomCar_Element, ZoomCar_Browser {
	public static RemoteWebDriver driver;
	public WebDriverWait wait;    

	public void invokeApp(String browser, String url) {
		 try {
	            if(browser.equalsIgnoreCase("chrome")) {
	                driver = new ChromeDriver();
	            }else if(browser.equalsIgnoreCase("firefox")) {
	                driver = new FirefoxDriver();
	            }
	            driver.get(url);
	            driver.manage().window().maximize();
	            Thread.sleep(5000);
	            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	        } catch (Exception e){
	         System.err.println(e);    
	        }
		
	}

	public void closeApp() {
		 try {
	            driver.close();
	        }catch (Exception e){
	             System.err.println(e);  
	             }
	}

	public void click(WebElement element, String desc) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
            reportStep("Clicked on the element" +desc ,"pass");

        }catch(Exception e) {
            reportStep("Unable to click on the element" +desc ,"fail");
            System.err.println(e);
        }
	}
	  
	public void enterText(WebElement element, String data) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        	wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(data);
            reportStep("Entered "+data+" in the textbox", "pass");


        }catch(Exception e) {
        	reportStep("Unable to enter "+data+" in the textbox", "fail");
        	System.err.println(e);
        }
	}
	
	@Override
	public long takeSnap() {
        long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
        try {
        	File source = driver.getScreenshotAs(OutputType.FILE); 
        	FileUtils.copyFile(source, new File("./reports/images/"+number+".jpg"));
        } catch (WebDriverException e) {
            System.out.println("The browser has been closed.");
        } catch (IOException e) {
            System.out.println("The snapshot could not be taken");
        }
        return number;
    }

	public void mouseHover(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf (element));
        Actions hover = new Actions(driver);
        hover.moveToElement(element).perform();		
	}
	
	public void secondLocation(List<WebElement> element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,250)", "");
    if (element.size() > 1) {
        WebElement secondLocation = element.get(1);
        secondLocation.click();
    	}
    }
	
	public void startAndEndSlider(WebElement elementStart, WebElement elementEnd) {
		wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf (elementStart));
        Actions slider = new Actions(driver);
		slider.clickAndHold(elementStart);
		slider.moveByOffset(-130, 0).release().build().perform();
		wait.until(ExpectedConditions.visibilityOf (elementEnd));
		slider.clickAndHold(elementEnd);
		slider.moveByOffset(100, 0).release().build().perform();
	}
	
	public String newlyAddedCars(List<WebElement> elements) {
	    String newCarNames = elements.toString();
	    if (!elements.isEmpty()) {
	        StringBuilder carNamesBuilder = new StringBuilder();
	        for (WebElement carName : elements) {
	            String carNameText = carName.getText();
	            System.out.println(carNameText);
	            carNamesBuilder.append(carNameText).append(", ");
	        }
	        newCarNames = carNamesBuilder.substring(0, carNamesBuilder.length() - 2);
	        reportStep("Newly Added Cars names are: " + newCarNames, "info");
	    }
	    return newCarNames;
	}
	
    public void highRatedCar(List<WebElement> element) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        	wait.until(ExpectedConditions.visibilityOfAllElements(element));
        double maxRating = -1;
        int maxIndex = -1;
        for (int i = 0; i < element.size(); i++) {
        	String ratingString[] = element.get(i).getText().trim().split(" ");
        	Float ratingText = Float.parseFloat(ratingString[0]);
            double rating = ratingText.doubleValue();
            if (rating > maxRating) {
                maxRating = rating;
                maxIndex = i;
            }
            
        if (maxIndex != -1) {
            WebElement maxRatingCar = element.get(maxIndex);
            maxRatingCar.click();
        	}
        }
        reportStep("Clicked the Maximum Rated Car", "pass");

    } catch(Exception e) {
        reportStep("Unable to select the Maximum Rated Car" , "fail");
        System.err.println(e);
    	}
    }
	
    
    public void listOfImages(List<WebElement> element) {
        if (element != null && element.size() > 2) {
            WebElement thirdCarImage = element.get(2);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", thirdCarImage);
        }
    }
    
}

