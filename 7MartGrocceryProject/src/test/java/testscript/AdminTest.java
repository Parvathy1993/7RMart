package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminTest extends Base {
	
	HomePage homepage;
	AdminPage adminpage;
	
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyUserIsAbleToLoginWithValidCredentials() throws IOException
	{
		
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.clickLogin();
		adminpage=homepage.clickManageAdminMoreInfo();
		//AdminPage adminpage=new AdminPage(driver);
		//adminpage.clickManageAdmin();
		//adminpage.clickNewAdmin();
		//String newusername=Excel_Utility.getStringData(1,0,"Admin");
		//String newpassword=Excel_Utility.getStringData(1,1,"Admin");
		FakerUtility fakerutility=new FakerUtility();
		String newusername=fakerutility.creatARandomFirstName();
		String newpassword=fakerutility.creatARandomLastName();
		adminpage.clickNewAdmin().enterUsername(newusername).enterPassword(newpassword).selectType().save();
		boolean alertisdisplayed=adminpage.alertIsDisplayed();
		Assert.assertTrue(alertisdisplayed,Messages.ADMINUSERCREATIONFAILED);

	}
	@Test
	public void verifyUserIsAbleToUpateAddeAdmins() throws IOException
	{
		
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.clickLogin();
		adminpage=homepage.clickManageAdminMoreInfo();
		String usernameadmin=ExcelUtility.getStringData(1,0,"Admin");
		adminpage.editAdmin().editUserName(usernameadmin).save();
		boolean alertisdisplayed=adminpage.alertIsDisplayed();
		Assert.assertTrue(alertisdisplayed,Messages.ADMINUSERUPDATEALERTNOTDISPLAYED);
   }
	
	@Test
	public void verifyWhetherTheUpateButtonIsenabled() throws IOException
	{
		

		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.clickLogin();
		adminpage=homepage.clickManageAdminMoreInfo();
		adminpage.editAdmin();
		boolean savebuttonisenabled=adminpage.isButtonEnabled();
		Assert.assertTrue(savebuttonisenabled,Messages.UPDATEBUTTONNOTENABLED);
 }
}


