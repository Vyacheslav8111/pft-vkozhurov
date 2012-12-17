package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager); /* super - обращение к базовому классу */
	}

	public void openMainPage() {
		driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void gotoGroupsPage() {
		driver.findElement(By.linkText("groups")).click(); /* обращение к manager вместо ApplicationManager сделано для того,
		чтобы ссылки public static WebDriver driver;
	public static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer() в ApplicationManager небыли "static" (для независимой работы драйверов)  */
	}

}
