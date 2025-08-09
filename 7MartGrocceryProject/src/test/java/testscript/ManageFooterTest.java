package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {
	HomePage homepage;
	ManageFooterPage managefooter;
	
	
	@Test
	public void verifyWhetherUserIsAbleToManageFooter() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		String email=ExcelUtility.getStringData(1,0,"Footer");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.clickLogin();
		managefooter=homepage.manageFooter();
		managefooter.action();
		managefooter.updateemail(email);
		managefooter.update();
		boolean alertisdisplayed=managefooter.alertIsDisplayed();
		Assert.assertTrue(alertisdisplayed,Messages.FOOTERUPDATEBUTTONNOTDISPLAYED);
		
	}
	@Test
	public void verifyWhetherAlertisDisplayedAfterUpdation() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		String email=ExcelUtility.getStringData(1,0,"Footer");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		homepage=loginpage.clickLogin();
		managefooter=homepage.manageFooter();
		managefooter.action().updateemail(email).update();
		boolean alertisdisplayed=managefooter.alertIsDisplayed();
		Assert.assertTrue(alertisdisplayed,Messages.FOOTERUPDATEALERTNOTDISPLAYED);
	}
}