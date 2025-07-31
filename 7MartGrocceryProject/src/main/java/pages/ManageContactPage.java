package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")WebElement moreinfobutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")WebElement actionsbutton;
	@FindBy(xpath="//input[@id='email']")WebElement emailfield;
	@FindBy(xpath="//button[@name='Update']")WebElement update;
	
	WebDriver driver;
	
	public ManageContactPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMoreInfo()
	{
		moreinfobutton.click();
	}
	
	public void clickAction()
	{
		actionsbutton.click();
	}
	
	public void updateEmail(String email)
	{
		emailfield.clear();
		emailfield.sendKeys(email);
	}
	
	public void update()
	{
		update.click();
	}
}
