package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class ApplicationManager {

	public void returnToGroupsPage() {
		TestBase.driver.findElement(By.linkText("group page")).click();
	}

	public void submitGroupCreation() {
		TestBase.driver.findElement(By.name("submit")).click();
	}

	public void initGroupCreation() {
		TestBase.driver.findElement(By.name("new")).click();
	}

	public void gotoGroupsPage() {
		TestBase.driver.findElement(By.linkText("groups")).click();
	}

	public void openMainPage() {
		TestBase.driver.get(TestBase.baseUrl + "/addressbookv4.1.4/");
	}

	public boolean isElementPresent(By by) {
		try {
			TestBase.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void fillContactForm(TestBase testBase, ContactData contact) {
		TestBase.driver.findElement(By.name("firstname")).clear();
		TestBase.driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
		TestBase.driver.findElement(By.name("lastname")).clear();
		TestBase.driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
		TestBase.driver.findElement(By.name("address")).clear();
		TestBase.driver.findElement(By.name("address")).sendKeys(contact.address);
		TestBase.driver.findElement(By.name("home")).clear();
		TestBase.driver.findElement(By.name("home")).sendKeys(contact.hometelephone);
		TestBase.driver.findElement(By.name("mobile")).clear();
		TestBase.driver.findElement(By.name("mobile")).sendKeys(contact.mobiletelephone);
		TestBase.driver.findElement(By.name("work")).clear();
		TestBase.driver.findElement(By.name("work")).sendKeys(contact.worktelephone);
		TestBase.driver.findElement(By.name("email")).clear();
		TestBase.driver.findElement(By.name("email")).sendKeys(contact.email);
		TestBase.driver.findElement(By.name("email2")).clear();
		TestBase.driver.findElement(By.name("email2")).sendKeys(contact.email_2);
		new Select(TestBase.driver.findElement(By.name("bday"))).selectByVisibleText("1");
		new Select(TestBase.driver.findElement(By.name("bmonth"))).selectByVisibleText("January");
		TestBase.driver.findElement(By.name("byear")).clear();
		TestBase.driver.findElement(By.name("byear")).sendKeys(contact.birthyear);
		TestBase.driver.findElement(By.name("address2")).clear();
		TestBase.driver.findElement(By.name("address2")).sendKeys(contact.secondary_address);
		TestBase.driver.findElement(By.name("phone2")).clear();
		TestBase.driver.findElement(By.name("phone2")).sendKeys(contact.secondary_phone);
	}

	public void returnToHomePage() {
		TestBase.driver.findElement(By.linkText("home page")).click();
	}

	public void submitContactCreation() {
		TestBase.driver.findElement(By.name("submit")).click();
	}

	public void initNewContactCreation() {
		TestBase.driver.findElement(By.linkText("add new")).click();
	}

	public void fillGroupForm(TestBase testBase, GroupData group) {
		TestBase.driver.findElement(By.name("group_name")).clear();
		TestBase.driver.findElement(By.name("group_name")).sendKeys(group.name);
		TestBase.driver.findElement(By.name("group_header")).clear();
		TestBase.driver.findElement(By.name("group_header")).sendKeys(group.header);
		TestBase.driver.findElement(By.name("group_footer")).clear();
		TestBase.driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	public void openHomePage() {
		TestBase.driver.findElement(By.linkText("home")).click();
	}

}
