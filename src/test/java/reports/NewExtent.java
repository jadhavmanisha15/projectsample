package reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NewExtent {
 public ExtentReports report=null;
 ExtentTest test=null;
  
 @BeforeSuite
 public void CreateReport()
 {
	 if(report==null)
	 {
		report=new ExtentReports("D:\\report\\reporz.html");
	 }
 }
 
 @BeforeMethod
 public void EveryTimeExecute(ITestResult result)
 {
	 if(test==null)
	 {
		test=report.startTest(result.getMethod().getMethodName());
	 }
 }
 
 @AfterMethod
 public void CloseEveryTime()
 {
	report.endTest(test);
 }
 @Test
 public void Method1() throws IOException
 {
	
	 System.setProperty("webdriver.chrome.driver", "D:\\manisha\\chromedriver\\CHROMEDRIVER.EXE");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equals("Googl"))
		{
		test.log(LogStatus.PASS, "passed");  
		Assert.assertTrue(true);
		
		}
		else {
			test.log(LogStatus.FAIL, "failled"); 
			Assert.assertTrue(false);
			File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("D://scr//xyzm.png"));
		}	
 }
 @AfterSuite
 public void CloseReport()
 {
	 report.flush();
	 report.close();
	 
 }
 
}
