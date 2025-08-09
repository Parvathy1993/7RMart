package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectByVisibleText(WebElement element, String visibleText) 
	{
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
	}
	  // Select dropdown by value
    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    // Select dropdown by index
    public void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }
 // Right click (context click)
    public void rightClick(WebElement element,WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    // Mouse hover
    public void mouseHover(WebElement element, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Drag and drop
    public void dragAndDrop(WebElement source, WebElement target, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    // Click using JavaScript
    public void clickByJS(WebElement element, JavascriptExecutor driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

  
    // Click with Actions class
    public void clickWithActions(WebElement element, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.click(element).perform();
    }
    
 // Set value using JavaScript (SendKeys)
    public void setValueByJS(WebElement element, String value, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='value';", element);
    }
 // Scroll down by pixel
    public void scrollDownByPixel(int pixels, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ");");
    }
    
    // Scroll up by pixel
    public void scrollUpByPixel(int pixels, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-" + pixels + ");");
    }
    // Scroll to bottom of page
    public void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
}




