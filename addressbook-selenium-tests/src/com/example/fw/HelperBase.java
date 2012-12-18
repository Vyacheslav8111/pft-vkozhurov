package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class HelperBase { /* abstract - ������������� �������� �������� ������� ���� (������ ������������ ����� ������� ������) */
	
	protected ApplicationManager manager; // ������ �� ApplicationManager, protected - ������� ����� ���������
	protected WebDriver driver;

	public HelperBase(ApplicationManager manager)  {
		this.manager = manager; /* this - ��������� �� ������ ������ ������� (� ������ ������ - manager)*/
		this.driver = manager.driver; // ���������������� ������ �� "driver" (�� ������ ������� "manager." ����� �������)
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected void type(By locator, String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}

	protected void selectByText(By locator, String text) {
		new Select(driver.findElement(locator)).selectByVisibleText(text);
	}

}