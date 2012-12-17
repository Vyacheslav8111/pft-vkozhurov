package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public abstract class HelperBase { /* abstract - ������������� �������� �������� ������� ���� (������ ������������ ����� ������� ������) */
	
	protected ApplicationManager manager; // ������ �� ApplicationManager, protected - ������� ����� ���������

	public HelperBase(ApplicationManager manager)  {
		this.manager = manager; /* this - ��������� �� ������ ������ ������� (� ������ ������ - manager)*/
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
