package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NewsPage;
import utilities.ExcelUtility;


public class NewsTest extends Base {
	
	@Test
	public void verifyWhetherUserCanAddNews() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		NewsPage newspage=new NewsPage(driver);
		newspage.clickManageNews();
		newspage.clickAddNews();
		String news=ExcelUtility.getStringData(1,0,"News");
		newspage.enterNews(news);
		newspage.save();
		Boolean alert=newspage.alertIsDiaplayed();
		Assert.assertTrue(alert);
		
	}


}
