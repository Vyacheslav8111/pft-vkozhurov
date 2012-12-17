package com.example.fw;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ApplicationManager {
	public  WebDriver driver;
	public  String baseUrl;
	
	public NavigationHelper navigationHelper; /*  для переноса в них методов делается ссылка "public NavigationHelper navigationHelper"; для 
	каждого метода своя*/
	
	public GroupHelper groupHelper;
	public ContactHelper contactHelper;
	
	
	public ApplicationManager() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void stop() {
		driver.quit();
		}
		
	}

