package utilities;

	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.io.FileHandler;

	public class ScreenshotUtility {
		
		 public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException
		 {  	//1)Typecasting WebDriver to Take Screenshot
		 		TakesScreenshot scrShot = (TakesScreenshot) driver; ////Selenium's TakesScreenshot interface is used to capture screenshots
		 		//2 Capturing the screenshot. 											
		 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//This line takes the screenshot and saves it as a temporary file of type File.
		 		// 3 Creating Timestamp 
		 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//This creates a timestamp like 26_07_2025_09_30_45 so that each screenshot has a unique name.
		 		//4–7: Creating Output Folder if Not Exists
		 		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// System.getProperty("user.dir") gets your current project directo																			 
		 		if (!f1.exists()) { 
		 			f1.mkdirs();  //This creates a folder called OutputScreenShot if it doesn't already exist.
		 		} 
		 		 //creating final destination path
		 		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp 
		 				+ ".png";
		 		//Creating File object
		 		File finalDestination = new File(destination); //Creates a File object representing the final destination for the screenshot.
		 		//copy screenshot to destination
		 		FileHandler.copy(screenShot, finalDestination);//Copies the temporary screenshot file to the final destination using FileHandler.  
		 	}

	}



