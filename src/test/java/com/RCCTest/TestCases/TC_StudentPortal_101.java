package com.RCCTest.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RCCTest.pageObjects.MyPortalPage;
import com.RCCTest.pageObjects.studentPortalPage;

public class TC_StudentPortal_101 extends BaseClass1 {
	@Test
	public void StudentPortal() throws InterruptedException, IOException {
		logger.info("Checking Student Portal");
		logger.info("url is opened");
		
		MyPortalPage mpp = new MyPortalPage(driver);
		mpp.getEmail(Email);
		logger.info("Email entered");
		mpp.getpassword(pwd);
		logger.info("password entered");
		mpp.getLogin();
		

		studentPortalPage spp=new studentPortalPage(driver);
		
		spp.clickProgName();
		logger.info(" Program Name : SAT Group Class  -  Weekend SAT");
		Thread.sleep(3000);
		spp.getProgramNames();
		Thread.sleep(2000);
		spp.returnHome();
		logger.info("Checking referral program");
		spp.clickRefferalProg();
		logger.info("Enter name of Referral");
		spp.EnterNameOfReferral();
		logger.info("Enter Email of Referral");
		spp.EnterEmailOfReferral();
		Thread.sleep(2000);
		logger.info("Return Home");
		spp.returnHome();
		logger.info("Upload Photo");
		spp.clickUploadPhoto();
		Thread.sleep(2000);
		logger.info("Return Home");
		spp.returnHome();
		Thread.sleep(2000);
		
		mpp.closeTab();

	}
}