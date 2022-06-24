package com.RCCTest.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class studentPortalPage {

	WebDriver driver;

	public studentPortalPage(WebDriver driver) {  
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="heading0")
	WebElement progName;    //program name
	
	@FindBy(xpath="//table[@id='myTable']//tr")
	List<WebElement> options;   //List of Programmes
	
	@FindBy(xpath="//a[@id='studentHome']")
	WebElement home;  // Home button returns to Home
	
	@FindBy(xpath="//span[@class='lbl']")
	WebElement refferalProg;    //click on Referral program
	
	@FindBy(xpath="//input[@id='name']")
	WebElement enterName;   //Enter Name of the referral
	
	@FindBy(xpath="//input[@id='email']")
	WebElement enterEmail;  //Enter Email of the referral
	
	@FindBy(xpath="//a[@id='uploadProfilePhoto']//span")
	WebElement uploadphoto; //click on Upload Photo
	
	public void clickProgName() {
		progName.click();
	}

		 public void getProgramNames() {
					
					for(WebElement list:options) {
						String txt=list.getText();
						System.out.println(txt);
				 
					}
				}
		 
		public void returnHome() {
			home.click();
		}
		
		public void clickRefferalProg() {
			refferalProg.click();
		}
		
		public void EnterNameOfReferral() {
			enterName.sendKeys("Padma");
		}
		
		public void EnterEmailOfReferral() {
			enterName.sendKeys("padmja.vegesena@gmail.com");
		}
		
		public void clickUploadPhoto() {
			uploadphoto.click();
		}
		 
	}

	





