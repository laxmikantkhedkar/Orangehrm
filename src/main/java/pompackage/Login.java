//POM-Page object module is used to design the classes in test script.
//--To maintain code readability and reusability we use POM concept.
/*POM thumb rules:-
 *   1)one webpage should have one class.
 *   2)class name should simillar to functionality name.
 *   3)action on one element should have one method
 *   4)Method name should simillar to action name
 */
package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	@FindBy(xpath="//*[@placeholder='Username']")
	private WebElement username;

	@FindBy(xpath="//*[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")
	private WebElement LogInbutton;
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String sendUsername(String uname)
	{
		username.sendKeys(uname);
		return uname;
	}
	public String sendPassword(String pass)
	{
		password.sendKeys(pass);
		return pass;
	}
	public void clickonlogInButton()
	{
		LogInbutton.click();
	}
}
