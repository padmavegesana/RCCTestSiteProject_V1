package com.RCCTest.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RCCTest.Utilities.XLUtilityFile;
import com.RCCTest.pageObjects.MyPortalPage;

public class TC_MyPortalDDTest_100 extends BaseClass1{
	
	@Test(dataProvider="logindata")
	public void loginDDT(String un,String upwd,String exp) throws IOException{
		logger.info("Performing DataDriven Testing");
		if(un.equalsIgnoreCase("devang@yopmail.com") && pwd.equals("P@ssw0rd")&& exp.equals("Valid")){
			MyPortalPage mpp = new MyPortalPage(driver);
			mpp.getEmail(un);
			logger.info("Email entered");
			mpp.getpassword(upwd);
			logger.info("password entered");
			mpp.getLogin();
			Assert.assertTrue(true);
			logger.info("Login Successfull");
			System.out.println("UserNmae: "+un);
			System.out.println("Password: "+upwd);
			mpp.closeTab();
			
		}else {
			System.out.println("UserNmae: "+un);
			System.out.println("Password: "+upwd);
			logger.info("Login Failed");
			captureScreen(driver, "loginDDT");
			Assert.assertTrue(false);
			
			
		}
			
	}
	
	//dataprovider always return twodimensional array

	@DataProvider(name = "logindata")
	public Object[][] testdata() throws IOException {

		String path = ".//datafiles//loginData.xlsx";
		XLUtilityFile utility = new XLUtilityFile(path);
		int rows = utility.getrowcount("sheet1");
		int cols = utility.getcellcount("sheet1", 1);

		String logindata[][] = new String[rows][cols];

		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {
				logindata[i - 1][j] = utility.getcellvalue("sheet1", i, j);
			}
		}

		return logindata;
	} 

}
