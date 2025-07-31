package testscript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class ManageContactTest extends Base {
	
	@Test
	public void verifyWhetherUserCanUpdateContact() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		ManageContactPage managecontact=new ManageContactPage(driver);
		managecontact.clickMoreInfo();
		managecontact.clickAction();
		managecontact.updateEmail("parvathy.somanath@gmail.com");
		PageUtility pageUtil = new PageUtility();
	    pageUtil.scrollToBottom((JavascriptExecutor) driver);
	    managecontact.update();
	}

}
