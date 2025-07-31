package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminPage {
	
public WebDriver driver;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and@class='small-box-footer']") WebElement managenews;
	@FindBy(xpath="//a[@href='javascript:void(0)'and@class='btn btn-rounded btn-danger']") WebElement newadmin;
	@FindBy(xpath="//input[@id='username']")WebElement enterusername;
	@FindBy(xpath="//input[@id='password']")WebElement enterpassword;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	@FindBy(xpath="//div[@class='card-footer center']//button") WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successalert;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement dismissalert;
	@FindBy(xpath="//a[@role='button' and @href='https://groceryapp.uniqassosiates.com/admin/user/edit?edit=14925&page_ad=1']")WebElement adminedit;
	@FindBy(xpath="//input[@id='username']")WebElement editusername;
	
	public AdminPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickManageAdmin()
	{
		managenews.click();
	}
	public void clickNewAdmin()
	{
		newadmin.click();
	}
	public void enterUsername(String newusername)
	{
		enterusername.sendKeys(newusername);
	}
	public void enterPassword(String newpassword)
	{
		enterpassword.sendKeys(newpassword);
	}
	public void selectType()
	{
		//Select select=new Select(usertype); 
		//select.selectByVisibleText("Staff");
		PageUtility pageutility=new PageUtility();
		pageutility.selectByVisibleText(usertype, "Staff");
	}
	public void save()
	{
		savebutton.click();
	}
	public Boolean alertIsDisplayed()
	{
		return successalert.isDisplayed();
	}
	public Boolean dismissAlertIsDisplayed()
	{
		return dismissalert.isDisplayed();
	}
	public void editAdmin()
	{
		adminedit.click();
	}
	public void editUserName(String username)
	{
		editusername.clear();
		editusername.sendKeys(username);
	}
	public Boolean isButtonEnabled()
	{
		return savebutton.isEnabled();
	}
	

}



