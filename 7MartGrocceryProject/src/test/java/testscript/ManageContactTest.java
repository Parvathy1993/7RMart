package testscript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageContactTest extends Base {
	
	HomePage homepage;
	ManageContactPage managecontact;
	
	@Test
	public void verifyWhetherUserCanUpdateContact() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		String email=ExcelUtility.getStringData(1,0,"Contact");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.clickLogin();
		managecontact=homepage.clickMoreInfo();
	    managecontact.clickAction().updateEmail(email).update();
	    boolean isalertdisplayed=managecontact.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed,Messages.CONTACTUPDATEFAILED);
	}

}
