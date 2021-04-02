package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.adact.base.BaseClass2;
import com.adact.pages.HomePage;
import com.adact.pages.LoginPage;
import com.adact.util.ReadExcel;

public class HomePageTestcase extends BaseClass2
{
	LoginPage loginpage;
	HomePage homepage;

	public HomePageTestcase() 
	{
		super();
		initialization();
//		loginpage=new LoginPage();
		homepage=new HomePage();
	}

	@Test(dataProvider="dataprovider")
	public void loginTest(String usern,String pass)
	{
		homepage=loginpage.validatelogin(usern, pass);
	}

//	@Test(priority=2)
//	public void SelectLocationTest()
//	{
//		homepage.SelectLocation();
//	}
//
//	@Test(priority=3)
//	public void SelectHotelTest()
//	{
//		homepage.SelectHotel();
//	}
//
//	@Test(priority=4)
//	public void SelectRoomTypeTest()
//	{
//		homepage.SelectRoomType();
//	}
//
//	@Test(priority=4)
//	public void NumberOfRoomTest()
//	{
//		homepage.NumberOfRoom();
//	}

		@DataProvider(name="dataprovider")
		public Object[][] data()
		{
			Object[][] obj=ReadExcel.readExcelSheet("C:\\Users\\Hp\\eclipse-workspace\\AdactinHotelApp\\src\\main\\java\\com\\adact\\testdata\\testData.xlsx");
			return obj;
		}


}
