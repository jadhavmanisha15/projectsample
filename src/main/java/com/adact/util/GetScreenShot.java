package com.adact.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class GetScreenShot 
{
	public static String screenShot(WebDriver driver, String screenshotName) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		//File source=ts.getScreenshotAs(OutputType.FILE);
	      //File source=ts.getScreenshotAs(OutputType.FILE);
	      File source=ts.getScreenshotAs(OutputType.FILE);
		String dest="D:\\manisha\\screenshot\\"+screenshotName+".png";
		File finaldest=new File(dest);
		Files.copy(source, finaldest);
		return dest;
	}
}
