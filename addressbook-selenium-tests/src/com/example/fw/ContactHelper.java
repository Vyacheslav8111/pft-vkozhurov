package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewContactCreation() {
		driver.findElement(By.linkText("add new")).click();
	}

	public void fillContactForm(ContactData contact) {
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

	public void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

	public void returnToHomePage() {
		driver.findElement(By.linkText("home page")).click();
	}

	public void openHomePage() {
		driver.findElement(By.linkText("home")).click();
	}

}
