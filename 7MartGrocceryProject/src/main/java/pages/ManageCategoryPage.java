package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUpload_Utility;
import utilities.PageUtility;

public class ManageCategoryPage {

	FileUpload_Utility fileupload = new FileUpload_Utility();

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	WebElement clicknewcategory;
	@FindBy(xpath = "//input[@id='category']")
	WebElement addnewcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile;
	@FindBy(xpath = "//button[@name='create']")
	WebElement save;

	WebDriver driver;

	public WebElement save() {
		return save;
	}

	public ManageCategoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageCategoryPage clicknewcategory() {
		clicknewcategory.click();
		return this;
	}

	public ManageCategoryPage addnewcategory(String category) {
		addnewcategory.sendKeys(category);
		return this;
	}

	public ManageCategoryPage choosefile() {
		fileupload.fileUploadUsingSendKeys(choosefile,Constant.FRUITIMG);
		return this;
	}

	public void clickSave() {
		PageUtility pageUtil = new PageUtility();
	    pageUtil.scrollToBottom( driver);
		save.click();
	}

}
