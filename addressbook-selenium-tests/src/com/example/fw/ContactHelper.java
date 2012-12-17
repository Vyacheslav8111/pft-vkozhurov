package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.TestBase;

public class ContactHelper {

	public void initNewContactCreation() {
		ApplicationManager.driver.findElement(By.linkText("add new")).click();
	}

	public void fillContactForm(ApplicationManager applicationManager, TestBase testBase, ContactData contact) {
		ApplicationManager.driver.findElement(By.name("firstname")).clear();
		ApplicationManager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
		ApplicationManager.driver.findElement(By.name("lastname")).clear();
		ApplicationManager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
		ApplicationManager.driver.findElement(By.name("address")).clear();
		ApplicationManager.driver.findElement(By.name("address")).sendKeys(contact.address);
		ApplicationManager.driver.findElement(By.name("home")).clear();
		ApplicationManager.driver.findElement(By.name("home")).sendKeys(contact.hometelephone);
		ApplicationManager.driver.findElement(By.name("mobile")).clear();
		ApplicationManager.driver.findElement(By.name("mobile")).sendKeys(contact.mobiletelephone);
		ApplicationManager.driver.findElement(By.name("work")).clear();
		ApplicationManager.driver.findElement(By.name("work")).sendKeys(contact.worktelephone);
		ApplicationManager.driver.findElement(By.name("email")).clear();
		ApplicationManager.driver.findElement(By.name("email")).sendKeys(contact.email);
		ApplicationManager.driver.findElement(By.name("email2")).clear();
		ApplicationManager.driver.findElement(By.name("email2")).sendKeys(contact.email_2);
		new Select(ApplicationManager.driver.findElement(By.name("bday"))).selectByVisibleText("1");
		new Select(ApplicationManager.driver.findElement(By.name("bmonth"))).selectByVisibleText("January");
		ApplicationManager.driver.findElement(By.name("byear")).clear();
		ApplicationManager.driver.findElement(By.name("byear")).sendKeys(contact.birthyear);
		ApplicationManager.driver.findElement(By.name("address2")).clear();
		ApplicationManager.driver.findElement(By.name("address2")).sendKeys(contact.secondary_address);
		ApplicationManager.driver.findElement(By.name("phone2")).clear();
		ApplicationManager.driver.findElement(By.name("phone2")).sendKeys(contact.secondary_phone);
	}

	public void submitContactCreation() {
		ApplicationManager.driver.findElement(By.name("submit")).click();
	}

	public void returnToHomePage() {
		ApplicationManager.driver.findElement(By.linkText("home page")).click();
	}

	public void openHomePage() {
		ApplicationManager.driver.findElement(By.linkText("home")).click();
	}

}
