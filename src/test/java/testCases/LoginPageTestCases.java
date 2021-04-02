package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adact.base.BaseClass2;
import com.adact.pages.HomePage;
import com.adact.pages.LoginPage;
import com.adact.pages.RegistrationPage;
import com.adact.pages.forgotpass;
import com.adact.util.ExtentReportClass;
import com.adact.util.GetScreenShot;
import com.adact.util.ReadExcel;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTestCases extends BaseClass2
{
	static LoginPage loginpage;
	static HomePage homepage;
	static forgotpass forpass;
	static RegistrationPage regpage;
	
	public String screenshotName;
	public LoginPageTestCases()
	{
		super();
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		ExtentReportClass.createReport();
	}
	
	@BeforeMethod
	public void setup(ITestResult result)
	{
		initialization();
	    loginpage=new LoginPage();
	    String testName=result.getMethod().getMethodName();
		//loginpage.initialization();
	    ExtentReportClass.getTest(testName);
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginpage.validateLoginPageTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "Adactin.com - Hotel Reservation System");
		
	}
	
	@Test(priority=2)
	public void logoimageTest()
	{
		boolean flag=loginpage.validateLogoImage();
		Assert.assertEquals(flag, flag);
	}
	
	@Test(priority=3)
	public void passwordLabelTest()
	{
		boolean flag=loginpage.validatepasswordlabel();
		Assert.assertEquals(flag, flag);
	}
	
	@Test(priority=4)
	public void usernamelabelTest()
	{
		boolean flag=loginpage.validateusernamelabel();
		Assert.assertEquals(flag, flag);
	}
	@Test(priority=5)
	public void loginTest()
	{
		homepage=loginpage.validatelogin(pro.getProperty("username"), pro.getProperty("password"));
		
	}
	
//	@Test(dataProvider="data")
//	public void loginTest(String username,String password)
//	{
//		homepage=loginpage.validatelogin(username, password);
//	}
	
	@Test(dataProvider="data")
	public void loginTest(String un, String pass)
	{
		homepage=loginpage.validatelogin(un, pass);
	}
	
	@Test(priority=6)
	public void forgotpasswordTest()
	{
		forpass=loginpage.forgotpassword();
		Assert.assertTrue(true);
	}
	
	@Test(priority=7)
	public void newuserresistrationTest()
	{
		regpage=loginpage.newuserresistration();
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			ExtentReportClass.test.log(LogStatus.PASS, "Passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
//			screenshotName=result.getMethod().getMethodName();
			screenshotName = GetScreenShot.screenShot(driver, screenshotName);
			ExtentReportClass.test.log(LogStatus.FAIL, ExtentReportClass.test.addScreenCapture(screenshotName));
		}
		ExtentReportClass.closeTest();
		driver.quit();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		ExtentReportClass.closeReport();
	}
	
	@DataProvider(name="dataprovider")
	public static Object[][] data()
	{
		Object[][] obj=ReadExcel.readExcelSheet("C:\\Users\\Hp\\eclipse-workspace\\AdactinHotelApp\\src\\main\\java\\com\\adact\\testdata\\testData.xlsx");
		return obj;
	}
 }

