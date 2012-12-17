package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.TestBase;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewContactCreation() {
		manager.driver.findElement(By.linkText("add new")).click();
	}

	public void fillContactForm(ApplicationManager applicationManager, TestBase testBase, ContactData contact) {
		manager.driver.findElement(By.name("firstname")).clear();
		manager.driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
		manager.driver.findElement(By.name("lastname")).clear();
		manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
		manager.driver.findElement(By.name("address")).clear();
		manager.driver.findElement(By.name("address")).sendKeys(contact.address);
		manager.driver.findElement(By.name("home")).clear();
		manager.driver.findElement(By.name("home")).sendKeys(contact.hometelephone);
		manager.driver.findElement(By.name("mobile")).clear();
		manager.driver.findElement(By.name("mobile")).sendKeys(contact.mobiletelephone);
		manager.driver.findElement(By.name("work")).clear();
		manager.driver.findElement(By.name("work")).sendKeys(contact.worktelephone);
		manager.driver.findElement(By.name("email")).clear();
		manager.driver.findElement(By.name("email")).sendKeys(contact.email);
		manager.driver.findElement(By.name("email2")).clear();
		manager.driver.findElement(By.name("email2")).sendKeys(contact.email_2);
		new Select(manager.driver.findElement(By.name("bday"))).selectByVisibleText("1");
		new Select(manager.driver.findElement(By.name("bmonth"))).selectByVisibleText("January");
		manager.driver.findElement(By.name("byear")).clear();
		manager.driver.findElement(By.name("byear")).sendKeys(contact.birthyear);
		manager.driver.findElement(By.name("address2")).clear();
		manager.driver.findElement(By.name("address2")).sendKeys(contact.secondary_address);
		manager.driver.findElement(By.name("phone2")).clear();
		manager.driver.findElement(By.name("phone2")).sendKeys(contact.secondary_phone);
	}

	public void submitContactCreation() {
		manager.driver.findElement(By.name("submit")).click();
	}

	public void returnToHomePage() {
		manager.driver.findElement(By.linkText("home page")).click();
	}

	public void openHomePage() {
		manager.driver.findElement(By.linkText("home")).click();
	}

}
