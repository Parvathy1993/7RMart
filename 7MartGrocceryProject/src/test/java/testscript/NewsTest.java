package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;


public class NewsTest extends Base {
	HomePage homepage;
	NewsPage newspage;
	
	@Test
	public void verifyWhetherUserCanAddNews() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.clickLogin();
		newspage=homepage.clickManageNewsMoreInfo();
		String news=ExcelUtility.getStringData(1,0,"News");
		newspage.clickAddNews().enterNews(news).save();
		boolean alert=newspage.alertIsDiaplayed();
		Assert.assertTrue(alert,Messages.ADDNEWSALERTNOTDISPLAYED);
		
	}


}
