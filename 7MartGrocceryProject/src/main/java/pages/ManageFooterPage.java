package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")WebElement actions;
	@FindBy(xpath="//input[@id='email']")WebElement updateemail;
	@FindBy(xpath="//button[@name='Update']")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	WebDriver driver;
	
	public ManageFooterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public ManageFooterPage action()
	{
		actions.click();
		return this;
	}
	public ManageFooterPage updateemail(String email)
	{
		updateemail.clear();
		updateemail.sendKeys(email);
		return this;
	}
	public ManageFooterPage update()
	{
		update.click();
		return this;
	}
	public Boolean alertIsDisplayed()
	{
		return alert.isDisplayed();
	}

}
