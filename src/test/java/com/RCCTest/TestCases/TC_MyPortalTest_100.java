package com.RCCTest.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RCCTest.Utilities.XLUtilityFile;
import com.RCCTest.pageObjects.MyPortalPage;

public class TC_MyPortalTest_100 extends BaseClass1 {
	@Test
	public void myPortal() throws IOException {
		logger.info("Checking credentials for Student Login");
		logger.info("URL entered");

		// creating object of myportal page
		MyPortalPage mpp = new MyPortalPage(driver);
		mpp.getEmail(Email);
		logger.info("Email entered");
		mpp.getpassword(pwd);
		logger.info("password entered");
		mpp.getLogin();

		if (driver.getTitle().equalsIgnoreCase("Ramana Coaching Center")) {
			Assert.assertTrue(true);
			logger.info("Test passed");
		} else {
			captureScreen(driver, "myPortal");
			Assert.assertTrue(false);
			logger.info("Test Failed");
		}
		mpp.closeTab();
		logger.info("Tab closed");
	}

}
