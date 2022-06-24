package com.RCCTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MyPortalPage {
      
	WebDriver driver;
	
	 public MyPortalPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="j_username")
	WebElement userEmail;     //Email id
	
	@FindBy(id="j_password")
	WebElement userpwd;       //password

	@FindBy(id="loginbtn")
	WebElement login;         //Log in
	
	@FindBy(linkText="Logout")
	WebElement logOut;       //Log out
	
	public void getEmail(String email) {
		userEmail.sendKeys(email);
	}
	
	public void getpassword(String pwd) {
		userpwd.sendKeys(pwd);
	}
	
	public void getLogin() {
		login.click();
	}
	public void closeTab() {
		logOut.click();
	}
	
	
	
}
