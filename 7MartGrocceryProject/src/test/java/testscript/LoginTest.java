package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
		@Test
		public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException
		{
			//String username="admin";
			//String password="admin";
			String username=ExcelUtility.getStringData(1,0,"LoginPage");
			String password=ExcelUtility.getStringData(1,1,"LoginPage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUsername(username);
			loginpage.enterPassword(password);
			loginpage.clickLogin();
			Boolean ishomepagedisplayed=loginpage.isDashboardDisplayed();
			Assert.assertTrue(ishomepagedisplayed);
			
		}
		@Test
		public void verifyUserIsAbleToLoginWithInValidCredentials()
		{
			String username="admin";
			String password="test";
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUsername(username);
			loginpage.enterPassword(password);
			loginpage.clickLogin();
			Boolean isalertdisplayed=loginpage.isAlertDisplayed();
			Assert.assertTrue(isalertdisplayed);
		}
		@Test
		public void verifyUserIsAbleToLoginWithInValidCredentials1()
		{
			String username="test";
			String password="admin";
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUsername(username);
			loginpage.enterPassword(password);
			loginpage.clickLogin();
			Boolean isalertdisplayed=loginpage.isAlertDisplayed();
			Assert.assertTrue(isalertdisplayed);
		}
		@Test
		public void verifyUserIsAbleToLoginWithInValidCredentials2()
		{
			String username="test";
			String password="tester";
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUsername(username);
			loginpage.enterPassword(password);
			loginpage.clickLogin();
			Boolean isalertdisplayed=loginpage.isAlertDisplayed();
			Assert.assertTrue(isalertdisplayed);
		}
}
