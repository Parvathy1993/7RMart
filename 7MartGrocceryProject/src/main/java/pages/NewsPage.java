package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsPage {
	
public WebDriver driver;
	
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add'and @onclick='click_button(1)']")WebElement addnew;
	@FindBy(xpath="//textarea[@id='news']") WebElement enternews;
	@FindBy(xpath="//button[@name='create']") WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	

	public NewsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public NewsPage clickAddNews()
	{
		addnew.click();
		return this;
	}
	public NewsPage enterNews(String news)
	{
		enternews.sendKeys(news);
		return this;
	}
	public NewsPage save()
	{
		savebutton.click();
		return this;
	}
	public boolean alertIsDiaplayed()
	{
		return alert.isDisplayed();
	}

}


