package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//3 types of 
//implicit wait(Framework>base>after loading the url),we use only once in the code, also called static wait
//wait-explicit wait(can provide to particular element, also called dynamic wait/inteligent wait) 
//fluent wait(not used commonly)

public class WaitUtility {
	
	public static final int IMPLICITWAIT=10;
	public static final int EXPLICITWAIT=10;
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	 public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }
	 
	 public static void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	    }
	 
	 public static void waitForAlertToBePresent(WebDriver driver) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	        wait.until(ExpectedConditions.alertIsPresent());
	    }

}
