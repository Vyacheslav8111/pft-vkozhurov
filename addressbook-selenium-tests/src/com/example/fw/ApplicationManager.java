package com.example.fw;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ApplicationManager {
	public  WebDriver driver;
	public  String baseUrl;
	private  StringBuffer verificationErrors = new StringBuffer();
	
	public NavigationHelper navigationHelper; /*  ��� �������� � ��� ������� �������� ������ "public NavigationHelper navigationHelper"; ��� 
	������� ������ ����*/
	
	public GroupHelper groupHelper;
	public ContactHelper contactHelper;
	
	
	public ApplicationManager() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void stop() {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		
	}

	


	

}
