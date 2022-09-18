package testpakage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pompackage.Homepage;
import pompackage.Login;



public class Test {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//verify Login fuctionality
		
		Login login=new Login(driver);
		login.sendUsername();
		login.sendPassword();
		login.clickonlogInButton();
		
		//verify Homepage
		Homepage home=new Homepage(driver);
		home.clickOnAddButton();
		home.sendFirstName("john");
		home.sendMiddleName("martin");
		home.sendLastName("sena");
		home.clickOnSaveButton();
	}

}
