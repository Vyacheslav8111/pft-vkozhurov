package com.example.fw;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class ApplicationManager {
	public static WebDriver driver;
	public static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();
	
	public NavigationHelper navigationHelper;;
	
	public ApplicationManager() {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void stop() {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
		
	}

	public void returnToGroupsPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	public void submitGroupCreation() {
		driver.findElement(By.name("submit")).click();
	}

	public void initGroupCreation() {
		driver.findElement(By.name("new")).click();
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void fillContactForm(TestBase testBase, ContactData contact) {
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

	public void returnToHomePage() {
		driver.findElement(By.linkText("home page")).click();
	}

	public void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

	public void initNewContactCreation() {
		driver.findElement(By.linkText("add new")).click();
	}

	public void fillGroupForm(TestBase testBase, GroupData group) {
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys(group.name);
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys(group.header);
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void openHomePage() {
		driver.findElement(By.linkText("home")).click();
	}


	

}
