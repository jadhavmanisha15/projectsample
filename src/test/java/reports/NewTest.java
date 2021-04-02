package reports;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest
{
	public ExtentReports reports=null;
	public ExtentTest test=null;

	@BeforeTest
	public void beforeTest()
	{
		if(reports==null)
		{
			reports=new ExtentReports("D:\\manisha\\report\\reportss.html");
		}
	}

	@Test
	public void openUrl() 
	{
		if(test==null)
		{
			test=reports.startTest("Url Open");
		}

		System.setProperty("webdriver.chrome.driver", "D:\\manisha\\chromedriver\\CHROMEDRIVER.EXE");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		
		
		if(driver.getTitle().equals("Adactin.com - Hotel Reservation System Hotel Reservation System"))
		{
			test.log(LogStatus.PASS, "Correct title");
		}
		
		if(test!=null)
		{
		reports.endTest(test);
		test=null;
		}
	}
	
	@Test
	public void login() 
	{
		if(test==null)
		{
			test=reports.startTest("Login");
		}

		System.setProperty("webdriver.chrome.driver", "D:\\manisha\\chromedriver\\CHROMEDRIVER.EXE");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);
		driver.get("http://adactinhotelapp.com/HotelAppBuild2/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("iamaniket007");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("aniket123");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		if(driver.getTitle().equals("Adactin.com - Search Hotel"))
		{
			test.log(LogStatus.PASS, "Login Successfully");
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
