package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	WebDriver driver;
	//1)datamembers()webelements
	
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	WebElement addbutton;
	
	@FindBy(xpath="//input[@placeholder=\"First Name\"]")
	WebElement firstname;

	@FindBy(xpath="//input[@placeholder=\"Middle Name\"]")
	WebElement middlename;
	
	@FindBy(xpath="//input[@placeholder=\"Last Name\"]")
	WebElement lastname;
	
	
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
	WebElement save;
	
	//2)constructor
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	//3)actions methods
	
	public void clickOnAddButton()
	{
		addbutton.click();
		
	}
	
	public String sendFirstName(String fname)
	{    
		//WebDriverWait wait=new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\\\"First Name\\\"]")));
		firstname.sendKeys(fname);
		return fname;
	}
	
	public String sendMiddleName(String mname)
	{
		middlename.sendKeys(mname);
		return mname;
	}
	
	public String sendLastName(String lname)
	{
		lastname.sendKeys(lname);
		return lname;
	}
	
	public void clickOnSaveButton()
	{
		save.click();
	}
}
