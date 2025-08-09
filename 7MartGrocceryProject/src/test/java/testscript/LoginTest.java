package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	HomePage homepage;
	
		@Test
		public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException
		{
			//String username="admin";
			//String password="admin";
			String username=ExcelUtility.getStringData(1,0,"LoginPage");
			String password=ExcelUtility.getStringData(1,1,"LoginPage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUsername(username).enterPassword(password);
			homepage=loginpage.clickLogin();
			Boolean ishomepagedisplayed=loginpage.isDashboardDisplayed();
			Assert.assertTrue(ishomepagedisplayed,Messages.LOGINVALIDCREDNTIALS);
			
		}
		@Test
		public void verifyUserIsAbleToLoginWithInValidCredentials() throws IOException
		{
			//String username="admin";
			//String password="test";
			String username=ExcelUtility.getStringData(2,0,"LoginPage");
			String password=ExcelUtility.getStringData(2,1,"LoginPage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUsername(username).enterPassword(password);
			homepage=loginpage.clickLogin();
			boolean isalertdisplayed=loginpage.isAlertDisplayed();
			Assert.assertTrue(isalertdisplayed,Messages.LOGININVALIDCREDENTIALS);
			
		}
		@Test
		public void verifyUserIsAbleToLoginWithInValidCredentials1() throws IOException
		{
			//String username="test";
			//String password="admin";
			String username=ExcelUtility.getStringData(3,0,"LoginPage");
			String password=ExcelUtility.getStringData(3,1,"LoginPage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUsername(username).enterPassword(password);
			homepage=loginpage.clickLogin();
			boolean isalertdisplayed=loginpage.isAlertDisplayed();
			Assert.assertTrue(isalertdisplayed,Messages.LOGININVALIDUSERNAME);
		}
		@Test(dataProvider ="LoginProvider")
		public void verifyUserIsAbleToLoginWithInValidCredentials2(String username, String password)
		{
			//String username="test";
			//String password="tester";
			//String username=ExcelUtility.getStringData(4,0,"LoginPage");
			//String password=ExcelUtility.getStringData(4,1,"LoginPage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUsername(username).enterPassword(password);
			homepage=loginpage.clickLogin();
			boolean isalertdisplayed=loginpage.isAlertDisplayed();
			Assert.assertTrue(isalertdisplayed,Messages.LOGININVALIDCREDENTIALS);	
		}
		
		@DataProvider(name="LoginProvider")
		public Object[][] getDataFromTestData() throws IOException{
			return new Object[][] {{ExcelUtility.getStringData(4, 0,"loginpage"),ExcelUtility.getStringData(4,1,"loginpage")}};
		}
}