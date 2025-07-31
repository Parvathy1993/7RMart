package testscript;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryTest extends Base{
	@Test(groups= {"regression"})
	public void verifyWhetherUserCanAddNewCategory() throws IOException
	{
		String username=ExcelUtility.getStringData(1,0,"LoginPage");
		String password=ExcelUtility.getStringData(1,1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		ManageCategoryPage managecategory=new ManageCategoryPage(driver);
		managecategory.managecategory();
		managecategory.clicknewcategory();
		managecategory.addnewcategory("fruit");
		WebElement choosefile=managecategory.getFileUploadInput();
		managecategory.choosefile(choosefile,"C:\\Users\\ParvathySomanathanPi\\Downloads\\kiwiFruit.jpg");
		PageUtility pageUtil = new PageUtility();
	    pageUtil.scrollToBottom((JavascriptExecutor) driver);
	    WebElement clicksave=managecategory.save();
	    WaitUtility wt=new WaitUtility();
	    wt. waitForElementToBeVisible(driver,clicksave);
	    managecategory.clickSave();
	}
}
