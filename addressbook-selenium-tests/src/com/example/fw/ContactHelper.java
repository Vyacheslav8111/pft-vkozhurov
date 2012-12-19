package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initNewContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		 type(By.name("firstname"), contact.firstname);
         type(By.name("lastname"), contact.lastname);
         type(By.name("address"), contact.address);
         type(By.name("home"), contact.hometelephone);
         type(By.name("mobile"), contact.mobiletelephone);
         type(By.name("work"), contact.worktelephone);
         type(By.name("email"), contact.email);
         type(By.name("email2"), contact.email_2);
         new Select(driver.findElement(By.name("bday"))).selectByVisibleText("1");
         new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("January");
         type(By.name("byear"), contact.birthyear);
         type(By.name("address2"), contact.secondary_address);
         type(By.name("phone2"), contact.secondary_phone);
	}


	public void submitContactCreation() {
	click(By.name("submit"));
	}

	public void returnToHomePage() {
	click(By.linkText("home page"));
	}

	public void openHomePage() {
	click(By.linkText("home"));
	}

	public void deleteContact(int index) {
		click(By.xpath("//tr[@name = 'entry'][" + index + "]/td[7]/a/img"));
		  click(By.name("update"));
		
	}

}
