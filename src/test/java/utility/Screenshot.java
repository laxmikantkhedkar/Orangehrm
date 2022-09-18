package utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public static String captureScreenshot(WebDriver driver) throws IOException
	{
	
		
//1)convert web driver object into Takescreenshot interface by using explicit casting
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
//2)call to getscreenshotAs()method using .operator and pass output type as parameter to method
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		System.out.println(SrcFile);
		
//3)copy file from default loction to specified location using static method of file handler class.
		String path="F:\\TESTING NOTES\\"+ System.currentTimeMillis()+".jpg";
		File dest = new File(path);
		FileHandler.copy(SrcFile, dest);
	//	FileUtils.copyFile(SrcFile, dest);
		return path;
	}

}
