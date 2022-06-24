package com.RCCTest.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.RCCTest.Utilities.Readconfig1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	
	public static WebDriver driver;
	public static Logger logger;
	Readconfig1 readconfig1=new Readconfig1();
	public String BaseUrl=readconfig1.getBaseUrl();
	public String Email=readconfig1.getEmail();
	public String pwd=readconfig1.getPwd();
	
	
	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();
	      driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(BaseUrl);
		
		//Log4j to get the Logs of Entire Project
		 logger=logger.getLogger("RCCTestSiteProject_V1");
		 PropertyConfigurator.configure("log4j.properties"); 
		 
	}

	//Screen shot Method
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		String strDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(date);
		File target=new File(System.getProperty("user.dir") + "/ScreenShots1/" + tname +strDate+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		 
	 }
	
	@AfterClass
	public void tearDown() {

		driver.close();
	}  
}
