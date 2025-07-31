package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base{

	@Test
	public void verifyWhetherUserIsAbleToLogout() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		LogoutPage logout=new LogoutPage(driver);
		logout.clickAdmin();
		logout.clickLogout();
	}
	

}
