package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class HelperBase { /* abstract - предотвращает создание объектов данного типа (объект абстрактного класа создать нельзя) */
	
	protected ApplicationManager manager; // ссылка на ApplicationManager, protected - условие общей видимости
	protected WebDriver driver;

	public HelperBase(ApplicationManager manager)  {
		this.manager = manager; /* this - указывает на данные внутри объекта (в данном случае - manager)*/
		this.driver = manager.driver; // непосредственная ссылка на "driver" (из других классов "manager." можно удалить)
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
	  if(text != null){
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);  
	  }
		
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}

	

}
