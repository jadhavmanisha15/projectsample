package reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentreport1 {
	ExtentReports report=null;
	ExtentTest test=null;
	@BeforeTest
	public void CreateReport()
	{
		if(report==null)
		{
		report=new ExtentReports("D:\\report\\reports.html");
		}
	}
	
	@Test
	public void Test1()
	{
		if(test==null)
		{
			test=report.startTest("Test1");
		}
		System.setProperty("webdriver.chrome.driver", "D:\\manisha\\chromedriver\\CHROMEDRIVER.EXE");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		test.log(LogStatus.PASS, "Correct title");
        if(test!=null)
        {
         report.endTest(test);
        }

	}
	@AfterMethod
	public void Closereport()
	{
		if(report!=null)
		{
			report.flush();
			report.close();
		}
	}
	

}
