package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	@FindBy (xpath="//a[@data-toggle='dropdown']")WebElement adminbutton;
	@FindBy (xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logout;
	
	WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickAdmin()
	{
		adminbutton.click();
	}
	public void clickLogout()
	{
		logout.click();
	}
}
