package testscript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryTest extends Base{
	
	HomePage homepage;
	ManageCategoryPage managecategory;
	
	
	@Test(groups= {"regression"}, description="verify Whether User Can Add a New Category")
	public void verifyWhetherUserCanAddNewCategory() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		String fruit=ExcelUtility.getStringData(1,0,"Category");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		homepage=loginpage.clickLogin();
		managecategory=homepage.manageCategoryInfo();
		managecategory.clicknewcategory().addnewcategory(fruit).choosefile();
	    managecategory.clickSave();
	   
	}
}
