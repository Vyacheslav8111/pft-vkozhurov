package com.example.fw;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ApplicationManager {
	public  WebDriver driver;
	public  String baseUrl;
	
	private NavigationHelper navigationHelper; /*  для переноса в них методов делается ссылка "public NavigationHelper navigationHelper"; для 
	каждого метода своя*/
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	
	public  ApplicationManager() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// предварительная инициализация
		/*
		navigationHelper = new NavigationHelper(this);
		groupHelper = new GroupHelper(this);
		contactHelper = new ContactHelper(this);
		*/
	}
	public void stop() {
		driver.quit();
	}

	// "ленивая инициализация" - методы вызываются тогда, когда они необходимы
	
	public NavigationHelper getNavigationHelper(){ // создаем метод, который возвращает NavigationHelper - getNavigationHelper
	if (navigationHelper == null) {
	navigationHelper = new NavigationHelper(this);	
	}
	return 	navigationHelper;
	}
	
	public GroupHelper getGroupHelper(){ 
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);	
		}
		return 	groupHelper;
		}
	public ContactHelper getContactHelper(){ 
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);	
		}
		return 	contactHelper;
		}	

}

