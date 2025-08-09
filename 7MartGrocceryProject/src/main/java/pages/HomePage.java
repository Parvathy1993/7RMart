package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//a[@class='small-box-footer'and @href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")
	WebElement managefooterinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement contactmoreinfobutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and@class='small-box-footer']")
	WebElement manageadminmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and@class='small-box-footer']")
	WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and@class='small-box-footer']")
	WebElement managecategoryinfo;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signin;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminbutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;

	WebDriver driver;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminPage clickManageAdminMoreInfo() {
		manageadminmoreinfo.click();
		return new AdminPage(driver);
	}

	public NewsPage clickManageNewsMoreInfo() {
		managenewsmoreinfo.click();
		return new NewsPage(driver);
	}

	public ManageCategoryPage manageCategoryInfo() {
		managecategoryinfo.click();
		return new ManageCategoryPage(driver);
	}

	public ManageFooterPage manageFooter() {
		managefooterinfo.click();
		return new ManageFooterPage(driver);
	}

	public ManageContactPage clickMoreInfo() {
		contactmoreinfobutton.click();
		return new ManageContactPage(driver);
	}

	public void clickAdmin() {
		adminbutton.click();
	}

	public void clickLogout() {
		logout.click();
	}
	public Boolean isSigninPageDisplayed() {
		return signin.isDisplayed();
	}
}
