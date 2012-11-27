package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupCreationTests {
	
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testNonEmptyGroupGreation() throws Exception {
		openMainPage();
		openGoToGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData();
		group.name = "group name 1";
		group.header = "header 1";
		group.footer = "footer 1";
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();
	}
	@Test
	public void testEmptyGroupGreation() throws Exception {
		openMainPage();
		openGoToGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData("", "", "");
		fillGroupForm(group);
		submitGroupCreation();
		returnToGroupsPage();
	}
	private void returnToGroupsPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	private void submitGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}

	private void fillGroupForm(GroupData group) {
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

	private void openGoToGroupsPage() {
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