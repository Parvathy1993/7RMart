package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	
	public FileInputStream fileinput;
	Properties properties;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void browserInitilization(String browser) throws Exception
	{
		try
		{
			properties=new  Properties();
			fileinput=new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinput);
		}
		catch(Exception e)
		{
			System.out.println("Invalid");
		}
		if(browser.equalsIgnoreCase("Chrome")) 
		{
	    driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else 
		{
			throw new Exception("Browser is Invalid");
		}
		//driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun=true)
		public void browserQuit(ITestResult iTestResult) throws IOException {
			if (iTestResult.getStatus() == ITestResult.FAILURE) {
				ScreenshotUtility scrShot = new ScreenshotUtility(); // creating obj
				scrShot.getScreenShot(driver, iTestResult.getName());
			}	
			driver.quit();	
	}
			
}

