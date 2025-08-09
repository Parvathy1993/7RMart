package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminPage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@href='javascript:void(0)'and@class='btn btn-rounded btn-danger']")
	WebElement newadmin;
	@FindBy(xpath = "//input[@id='username']")
	WebElement enterusername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement enterpassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertype;
	@FindBy(xpath = "//div[@class='card-footer center']//button")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successalert;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement dismissalert;
	@FindBy(xpath = "//a[@role='button' and @href='https://groceryapp.uniqassosiates.com/admin/user/edit?edit=14925&page_ad=1']")
	WebElement adminedit;
	@FindBy(xpath = "//input[@id='username']")
	WebElement editusername;

	public AdminPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminPage clickNewAdmin() {
		newadmin.click();
		return this;
	}

	public AdminPage enterUsername(String newusername) {
		enterusername.sendKeys(newusername);
		return this;
	}

	public AdminPage enterPassword(String newpassword) {
		enterpassword.sendKeys(newpassword);
		return this;
	}

	public AdminPage selectType() {
		// Select select=new Select(usertype);
		// select.selectByVisibleText("Staff");
		PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleText(usertype, "Staff");
		return this;
	}

	public AdminPage save() {
		savebutton.click();
		return this;
	}

	public boolean alertIsDisplayed() {
		return successalert.isDisplayed();
	}

	public boolean dismissAlertIsDisplayed() {
		return dismissalert.isDisplayed();
	}

	public AdminPage editAdmin() {
		adminedit.click();
		return this;
	}

	public AdminPage editUserName(String username) {
		editusername.clear();
		editusername.sendKeys(username);
		return this;
	}

	public boolean isButtonEnabled() {
		return savebutton.isEnabled();
	}

}
