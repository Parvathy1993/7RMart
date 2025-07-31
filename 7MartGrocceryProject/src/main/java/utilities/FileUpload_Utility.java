package utilities;


	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;


	import org.openqa.selenium.WebElement;


	public class FileUpload_Utility{
		
		public void fileUploadUsingSendKeys(WebElement element, String path) {
			element.sendKeys(path);

		}
		public void fileUploadUsingRobotClass(WebElement element,String path) throws AWTException //second method using Robot class
		{
			StringSelection s = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
			Robot r=new Robot();
			r.delay(2500);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}

	}


