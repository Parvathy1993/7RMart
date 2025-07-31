package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends Base {
	
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException
	{
		
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		AdminPage adminpage=new AdminPage(driver);
		adminpage.clickManageAdmin();
		adminpage.clickNewAdmin();
		//String newusername=Excel_Utility.getStringData(1,0,"Admin");
		//String newpassword=Excel_Utility.getStringData(1,1,"Admin");
		FakerUtility fakerutility=new FakerUtility();
		String newusername=fakerutility.creatARandomFirstName();
		String newpassword=fakerutility.creatARandomLastName();
		adminpage.enterUsername(newusername);
		adminpage.enterPassword(newpassword);
		adminpage.selectType();
		adminpage.save();
		Boolean alertisdisplayed=adminpage.alertIsDisplayed();
		Assert.assertTrue(alertisdisplayed);

	}
	@Test
	public void verifyUserIsAbleToUpateAddeAdmins() throws IOException
	{
		
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		AdminPage adminpage=new AdminPage(driver);
		adminpage.clickManageAdmin();
		adminpage.editAdmin();
		adminpage.editUserName("Hello");
		adminpage.save();
		Boolean alertisdisplayed=adminpage.alertIsDisplayed();
		Assert.assertTrue(alertisdisplayed);
   }
	
	@Test
	public void verifyWhetherTheUpateButtonIsenabled() throws IOException
	{
		
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		AdminPage adminpage=new AdminPage(driver);
		adminpage.clickManageAdmin();
		adminpage.editAdmin();
		Boolean savebuttonisenabled=adminpage.isButtonEnabled();
		Assert.assertTrue(savebuttonisenabled);
 }
}


