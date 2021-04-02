package reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {
public ExtentReports report;
public ExtentTest test;

@BeforeTest
public void CreateReport()
{
	if(report==null)
	{
		report=new ExtentReports("D:\\manisha\\report\\report1s.html");
	}
}
public void m1(ITestResult result)
{
	if(test==null)
	{
		test=report.startTest(result.getMethod().getMethodName());
		
	}
	System.setProperty("webdriver.chrome.driver", "D:\\manisha\\chromedriver\\CHROMEDRIVER.EXE");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
	driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);
	driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
	
}
}
