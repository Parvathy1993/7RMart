package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	
	@FindBy(xpath="//a[@class='small-box-footer'and @href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")WebElement managefooter;
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
	
	public void manageFooter()
	{
		managefooter.click();
	}
	public void action()
	{
		actions.click();
	}
	public void updateemail(String email)
	{
		updateemail.clear();
		updateemail.sendKeys(email);
	}
	public void update()
	{
		update.click();
	}
	public Boolean alertIsDisplayed()
	{
		return alert.isDisplayed();
	}

}
