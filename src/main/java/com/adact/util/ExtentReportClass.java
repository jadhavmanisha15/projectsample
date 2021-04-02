package com.adact.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tools.ant.taskdefs.Concat;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportClass
{
	
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	
//	create extent report
	public static void createReport() 
	{
		String reportname=setNameForReport();
			report=new ExtentReports(reportname);
			report.config().documentTitle("My report");
		/*if(report==null)
		{
			report.config().reportHeadline("Hello Adact");
			report.config().reportName("AdactIn Hotel App");
		}*/
	}
	
	
//	create extent test
	public static void getTest(String testName)
	{
		if(test==null)
		{
		test=report.startTest(testName);
		}
	}
	
//	close extent testCases
	public static void closeTest()
	{
		if(test!=null)
		{
			report.endTest(test);
			test=null;
		}
	}
	
	
	
//	close report
	public static void closeReport() 
	{
      if(report!=null)
      {
    	  report.flush();
    	  report.close();
    	  report=null;
      }
	}
	
	
//	set name of report as per date and time
	public static String setNameForReport()
	{
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date date=new Date();
		String dt=format.format(date);
		String finalReportname="D:\\manisha\\reports\\"+dt.replace(":","_")+".html";
		return finalReportname;
	}
}
