package com.adact.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.adact.base.BaseClass2;

public class HomePage extends BaseClass2
{
	@FindBy(css="select[name='location']")
	WebElement LocationDd;
	
	@FindBy(css="select[name='hotels']")
	WebElement HotelsDd;
	
	@FindBy(css="select[name=room_type]")
	WebElement RoomType;
	
	@FindBy(css="select[name='room_nos']")
	WebElement NumberOfRoom;
	
	@FindBy(css="input[name='datepick_in']")
	WebElement CheckInDate;
	
	@FindBy(css="input[name='datepick_out']")
	WebElement CheckOutDate;
	
	@FindBy(css="select[name='adult_room']")
	WebElement AdeltPerRoom;
	
    @FindBy(css="select[name='child_room']")
    WebElement ChildrenPerRoom;
    
    @FindBy(css="input[type='submit']")
    WebElement SearchButton;
    
    @FindBy(css="input[type='reset']")
    WebElement ResetButton;
    
//    public void LoginPage()
//	{
//		PageFactory.initElements(driver, this);
//	}
    
    public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
    
    public static Select select;
    public void SelectLocation()
    {
    	select=new Select(LocationDd);
     select.selectByVisibleText("London");
    }
    
    public void SelectHotel()
    {
    	select=new Select(HotelsDd);
    	select.selectByVisibleText("Hotel Sunshine");
    }
    
    public void SelectRoomType()
    {   
    	select=new Select(RoomType);
    	select.selectByVisibleText("Double");
    }
    
    public void NumberOfRoom()
    {
    	select=new Select(NumberOfRoom);
    	select.selectByValue("5");
    }
    
    public void sendCheckInDate(String date)
    {
    	CheckInDate.sendKeys(date);
    	
    }

}
