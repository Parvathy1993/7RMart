package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class HomePageTest extends Base{
	

	@Test
	public void verifyWhetherUserIsAbleToLogout() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		HomePage logout=new HomePage(driver);
		logout.clickAdmin();
		logout.clickLogout();
		Boolean sign = logout.isSigninPageDisplayed();
		Assert.assertTrue(sign, Messages.LOGOUTFAILED);
	}
	

}
