package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	
	WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeClass
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test1NonEmpryContactCreation() throws Exception {
		openMainPage();
		gotoAddNewPages();
		ContactData contact = new ContactData();
		contact.firstname = "firstname 1";
		contact.lastname = "lastname 1";
		contact.address = "address 1";
		contact.home = "home 1";
		contact.mobile = "mobile 1";
		contact.work = "work 1";
		contact.email = "email 1";
		contact.email2 = "email2 1";
		contact.byear = "byear 1";
		contact.address2 = "address2 1";
		contact.phone2 = "phone2 1";
		fillContactForm(contact);
		submitContactCreation();
		returnToHomePages();
	}
	
	@Test
	public void test1EmpryContactCreation() throws Exception {
		openMainPage();
		gotoAddNewPages();
		fillContactForm(new ContactData("", "", "", "", "", "", "", "", "", "", ""));
		submitContactCreation();
		returnToHomePages();
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
