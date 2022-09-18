
//tet class contain all navigation steps of test cases.
//test class is design in such way that for one fuctinality have one class
// those test cases have same prerequisite and postrequisite those are in one class



package testpakage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pompackage.Homepage;
import pompackage.Login;
import utility.Featchdata;
import utility.Screenshot;
import utility.pojo;

public class TestClass_Testng extends pojo {
	WebDriver driver;
	ExtentTest logger;
	ExtentReports extent;

	
	@BeforeClass
	public void openBrowser()
	{
		WebDriver driver= launchBrowser();
		this.driver=driver;
		
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./test-output/extentReport.html");
	    extent=new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("verifyLogInfunctionality");
		logger = extent.createTest("verifyHomepage");
		
		
	}
	
    @Test
	public void verifyLogInfunctionality() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException
	{
    		   Login login=new Login(driver);	
    		   login.sendUsername(Featchdata.logincredential(1, 0));   	
   			   login.sendPassword(Featchdata.logincredential(1, 4));
    		   login.clickonlogInButton();
    			
                String actual = driver.getCurrentUrl();
                String expected="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
            //    Screenshot.captureScreenshot(driver);
                Thread.sleep(2000);
       		 Assert.fail();
          	 
                
                
                
// Assertion are used to validate test cases by comparing actual result with expected result
//    			  Hard Assert
//                Assert.assertEquals(actual, expected);
//    			  Assert.assertNotEquals(actual, expected);
//                System.out.println("last line of test case");
//                
//                soft assertion
//                SoftAssert soft=new SoftAssert();
//                soft.assertNotEquals(actual, expected);
//                System.out.println("last line of test case");
//    			  soft.assertAll();
	}
    
    @Test(priority=1)
	public void verifyHomepage() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException
	{ 
    	Homepage home=new Homepage(driver);
    	
		home.clickOnAddButton();
		
		home.sendFirstName(Featchdata.logincredential(2, 0));
		
		home.sendMiddleName(Featchdata.logincredential(2, 1));
		
		home.sendLastName(Featchdata.logincredential(2, 2));
		Thread.sleep(2000);
		home.clickOnSaveButton();
		
		 Screenshot.captureScreenshot(driver);
	}
    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException
    {   
    	if(result.getStatus()== ITestResult.FAILURE)
    	{
    		String temp = Screenshot.captureScreenshot(driver);
    		logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
    	}
    	extent.flush();
    }
   
    @AfterClass
	public void afterclass()
	{
		driver.quit();
	}
}
