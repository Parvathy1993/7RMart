package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageContactPage {
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")WebElement actionsbutton;
	@FindBy(xpath="//input[@id='email']")WebElement emailfield;
	@FindBy(xpath="//button[@name='Update']")WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	WebDriver driver;
	
	public ManageContactPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public ManageContactPage clickAction()
	{
		actionsbutton.click();
		return this;
	}
	
	public ManageContactPage updateEmail(String email)
	{
		emailfield.clear();
		emailfield.sendKeys(email);
		return this;
	}
	
	public ManageContactPage update()
	{
		PageUtility pageUtil = new PageUtility();
	    pageUtil.scrollToBottom(driver);
	    WaitUtility wt=new WaitUtility();
	    wt.waitForElementToBeClickable(driver, update);
		update.click();
		return this;
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
