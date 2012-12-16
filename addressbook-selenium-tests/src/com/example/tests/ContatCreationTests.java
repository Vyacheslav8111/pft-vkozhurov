package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContatCreationTests {
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
	public void testNonEmptyContactCreation() throws Exception {
		openMainPage();
		openHomePage();
		initNewGroupCreation();
		ContactData contact = new ContactData();
		contact.firstname = "firstname 1";
		contact.lastname = "lastname 1";
		contact.address = "address 1";
		contact.hometelephone = "hometelephone 1";
		contact.mobiletelephone = "mobiletelephone 1";
		contact.worktelephone = "worktelephone 1";
		contact.email = "email 1";
		contact.email_2 = "email_2 1";
		contact.birthyear = "birthyear 1";
		contact.secondary_address = "secondary_address 1";
		contact.secondary_phone = "secondary_phone";
		submitContactCreation();
		gotoHomePage();
	}

	@Test
	public void testEmptyContactCreation() throws Exception {
		openMainPage();
		initNewGroupCreation();
		fillContactForm(new ContactData("", "", "", "", "", "", "", "", "", "", "", "", ""));
		submitContactCreation();
		gotoHomePage();
	}
	private void fillContactForm(ContactData contact) {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(contact.address);
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(contact.hometelephone);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(contact.mobiletelephone);
		driver.findElement(By.name("work")).clear();
		driver.findElement(By.name("work")).sendKeys(contact.worktelephone);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(contact.email);
		driver.findElement(By.name("email2")).clear();
		driver.findElement(By.name("email2")).sendKeys(contact.email_2);
		new Select(driver.findElement(By.name("bday"))).selectByVisibleText("1");
		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("January");
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys(contact.birthyear);
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys(contact.secondary_address);
		driver.findElement(By.name("phone2")).clear();
		driver.findElement(By.name("phone2")).sendKeys(contact.secondary_phone);
	}

	private void gotoHomePage() {
		driver.findElement(By.linkText("home page")).click();
	}

	private void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

	private void initNewGroupCreation() {
		driver.findElement(By.linkText("add new")).click();
	}

	private void openHomePage() {
		driver.findElement(By.linkText("home")).click();
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
