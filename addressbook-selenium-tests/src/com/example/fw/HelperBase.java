package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public abstract class HelperBase { /* abstract - предотвращает создание объектов данного типа (объект абстрактного класа создать нельзя) */
	
	protected ApplicationManager manager; // ссылка на ApplicationManager, protected - условие общей видимости

	public HelperBase(ApplicationManager manager)  {
		this.manager = manager; /* this - указывает на данные внутри объекта (в данном случае - manager)*/
	}

	public boolean isElementPresent(By by) {
		try {
			manager.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
