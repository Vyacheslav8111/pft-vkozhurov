package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager); /* super - ��������� � �������� ������ */
	}

	public void openMainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void gotoGroupsPage() {
		driver.findElement(By.linkText("groups")).click(); /* ��������� � manager ������ ApplicationManager ������� ��� ����,
		����� ������ public static WebDriver driver;
	public static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer() � ApplicationManager ������ "static" (��� ����������� ������ ���������)  */
	}

}
