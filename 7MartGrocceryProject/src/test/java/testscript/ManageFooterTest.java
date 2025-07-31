package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {
	@Test
	public void verifyWhetherUserIsAbleToManageFooter() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		ManageFooterPage managefooter= new ManageFooterPage(driver);
		managefooter.manageFooter();
		managefooter.action();
		managefooter.updateemail("parvathy+test@gmail.com");
		managefooter.update();
		
	}
	@Test
	public void verifyWhetherAlertisDisplayedAfterUpdation() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		ManageFooterPage managefooter= new ManageFooterPage(driver);
		managefooter.manageFooter();
		managefooter.action();
		managefooter.updateemail("parvathy+test@gmail.com");
		managefooter.update();
		Boolean alertisdisplayed=managefooter.alertIsDisplayed();
		Assert.assertTrue(alertisdisplayed);
	}
}