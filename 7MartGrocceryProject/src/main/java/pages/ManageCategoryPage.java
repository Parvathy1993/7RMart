package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUpload_Utility;

public class ManageCategoryPage {
	
	FileUpload_Utility fileupload=new FileUpload_Utility();

	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and@class='small-box-footer']")WebElement managecategory;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")WebElement clicknewcategory;
	@FindBy(xpath="//input[@id='category']")WebElement addnewcategory;
	@FindBy(xpath="//input[@id='main_img']")WebElement choosefile;
	@FindBy(xpath="//button[@name='create']")WebElement save;
	
	WebDriver driver;
	
	public WebElement save()
	{
		return save;
	}
	
	
	public ManageCategoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void managecategory()
	{
		managecategory.click();
	}
	public void clicknewcategory()
	{
		clicknewcategory.click();
	}
	public void addnewcategory(String category)
	{
		addnewcategory.sendKeys(category);
	}
	public WebElement getFileUploadInput() {
	    return choosefile;
	}
	public void choosefile(WebElement element,String path)
	{
		fileupload.fileUploadUsingSendKeys(element, path);
	}
	public void clickSave()
	{
		save.click();
	}

}
