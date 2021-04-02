package reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NewTest2
{
	public ExtentReports reports=null;
	public ExtentTest test=null;

	@BeforeTest
	public void beforeTest()
	{
		if (reports==null)
		{
			reports=new ExtentReports("D:\\manisha\\report\\reports.html");
		}
	}

	@BeforeMethod
	public void beforeMethod(ITestResult result)
	{
		if(test==null)
		{
			test=reports.startTest(result.getMethod().getMethodName());
		}
	}
	
	@Test
	public void openUrl() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\manisha\\chromedriver\\CHROMEDRIVER.EXE");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Hotel Reservation System");
		
//		if(driver.getTitle().equals("Adactin.com - Hotel Reservation System"))
//		{
//			test.log(LogStatus.PASS, "Correct title");
//		}
	}
	
	@Test
	public void login() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\manisha\\chromedriver\\CHROMEDRIVER.EXE");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("iamaniket007");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("aniket123");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		Assert.assertEquals(driver.getTitle(),"Adactin.com - Search Hotel");
		
//		if(driver.getTitle().equals("Adactin.com - Search Hotel"))
//		{
//			test.log(LogStatus.PASS, "Login Successfully");
//		}
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "Passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "Failed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP, "Skipped");
		}
		
		if(test!=null)
		{
			reports.endTest(test);
			test=null;
		}
	}
	
	@AfterTest
	public void afterTest() 
	{
		if (reports!=null)
		{
			reports.flush();
			reports.close();
		    reports=null;
		}
	}

}
