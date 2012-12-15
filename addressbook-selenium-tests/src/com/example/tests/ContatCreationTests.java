package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContatCreationTests {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled() throws Exception {
		driver.get(baseUrl + "/addressbookv4.1.4/");
		driver.findElement(By.linkText("home")).click();
		driver.findElement(By.linkText("add new")).click();
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys("abc");
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys("ABC");
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("street Soviet");
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys("house");
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys("332332");
		driver.findElement(By.name("work")).clear();
		driver.findElement(By.name("work")).sendKeys("878756");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("door@yandex.ru");
		driver.findElement(By.name("email2")).clear();
		driver.findElement(By.name("email2")).sendKeys("open@yandex.ru");
		new Select(driver.findElement(By.name("bday"))).selectByVisibleText("1");
		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("January");
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys("2001");
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys("Soviet street");
		driver.findElement(By.name("phone2")).clear();
		driver.findElement(By.name("phone2")).sendKeys("dorf");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("home page")).click();
	}

	@After
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
