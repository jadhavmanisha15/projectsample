package com.adact.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adact.base.BaseClass2;

public class LoginPage extends BaseClass2 
{
	@FindBy(css="input#username")
	WebElement username;

	@FindBy(css="input#password")
	WebElement password;

	@FindBy(css="input#login")
	WebElement loginBtn;

	@FindBy(css="[src='img/AdactIn_logo.png']")
	WebElement logo;

	@FindBy(css="table.login>tbody>tr:nth-child(2)")
	WebElement usernamelabel;
	
	@FindBy(css="table.login tr:nth-child(2)>td:nth-child(1)")
	WebElement passwordlabel;
	
	@FindBy(xpath="//div[@class='login_forgot']")
	WebElement forgetpasslink;
	
	@FindBy(xpath="//td[@class='login_register']")
	WebElement newuserregister;
	
	//Initializing the page object
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Action
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogoImage()
	 {
		 return logo.isDisplayed();
	 }
	
	public boolean validateusernamelabel()
	{
		return usernamelabel.isDisplayed();
	}
	
	public boolean validatepasswordlabel()
	{
		return passwordlabel.isDisplayed();
	}
	
	public boolean validateloginbutton()
	{
		return loginBtn.isDisplayed();
	}
	
	public boolean validateforgetpasslink()
	{
		return forgetpasslink.isDisplayed();
	}
	 public boolean validatenewuserregister()
	 {
		 return newuserregister.isDisplayed();
	 }
	
	 public HomePage validatelogin(String un,String pass)
	 {
		 username.sendKeys(un);
		 password.sendKeys(pass);
		 loginBtn.click();
		 return new HomePage();
	 }
	
	public forgotpass forgotpassword()
	{
		forgetpasslink.click();
		return new forgotpass();
	}
		
	public RegistrationPage newuserresistration()
	{
		newuserregister.click();
		return new RegistrationPage();
		
	}
	}
	
	




