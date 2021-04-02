package com.adact.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.adact.utils.UtilsClass;

public class BaseClass2
{
	public static WebDriver driver;
	public static Properties pro;
	public BaseClass2()
	{
		try {
			pro=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\AdactinHotelApp\\src\\main\\java\\com\\adact\\config\\config.properties");
			pro.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void initialization()
	{
		String browserName=pro.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\manisha\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver(); 
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		}
		else if(browserName.equalsIgnoreCase("ff"))
		{
			System.out.println("Gecko driver is not present;"); 
		}
			 driver.manage().window().maximize();
			 driver.manage().deleteAllCookies();
			 driver.manage().timeouts().pageLoadTimeout(UtilsClass.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			 driver.manage().timeouts().implicitlyWait(UtilsClass.IMPLICIT_WAIT,TimeUnit.SECONDS);
			 driver.get(pro.getProperty("url"));
	
}
}
