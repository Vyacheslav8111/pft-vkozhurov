package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AlsoGroupCreationTests {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@org.testng.annotations.Test
	public void testNonEmtpyGroupCreation() throws Exception {
		openMainPage();
		gotoGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData();
		group.name = "group name 1";
		group.header = "header";
		group.footer = "footer";
		fillGroupsForm(group);
		submitGroupCreation();
		returnToGroupsPage();
	}

	@org.testng.annotations.Test
	public void testEmtpyGroupCreation() throws Exception {
		openMainPage();
		gotoGroupsPage();
		initGroupCreation();
		fillGroupsForm(new GroupData("", "", ""));
		submitGroupCreation();
		returnToGroupsPage();
	}
	private void returnToGroupsPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	private void submitGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}

	private void fillGroupsForm(GroupData group) {
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys(group.name);
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys(group.header);
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	private void initGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	private void gotoGroupsPage() {
		driver.findElement(By.linkText("groups")).click();
	}

	private void openMainPage() {
		driver.get(baseUrl + "/addressbookv4.1.4/");
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
