package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class BaseHelper {

	protected ApplicationManager manager;
	protected WebDriver driver;

	public BaseHelper(ApplicationManager manager) {
		this.manager = manager;
		this.driver = manager.driver;
	}

public boolean isElementPresent(By by) {
	try {
		driver.findElement(by);
		return true;
	} catch (NoSuchElementException e) {
		return false;
	}
	}
}