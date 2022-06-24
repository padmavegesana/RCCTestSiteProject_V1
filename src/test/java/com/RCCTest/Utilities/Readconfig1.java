package com.RCCTest.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class Readconfig1 {

	Properties property;

	public Readconfig1() {

		File src = new File("./Configuration/config1.properties");
		try {
			FileInputStream input = new FileInputStream(src);
			property = new Properties();
			property.load(input);
		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		}
	}

	public String getBaseUrl() {
		String baseurl = property.getProperty("baseurl");
		return baseurl;
	}

	public String getEmail() {
		String email = property.getProperty("email");
		return email;
	}

	public String getPwd() {
		String pwd = property.getProperty("pwd");
		return pwd;
	}

}
