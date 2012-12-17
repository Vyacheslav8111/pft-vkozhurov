package com.example.tests;

import org.testng.annotations.Test;

public class ContatCreationTests extends TestBase{
	
	
	@Test
	public void testNonEmptyContactCreation() throws Exception {
		app.navigationHelper.openMainPage();
		app.contactHelper.openHomePage(); 
		app.contactHelper.initNewContactCreation();
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
		app.contactHelper.fillContactForm(app, this, contact);
		app.contactHelper.submitContactCreation();
		app.contactHelper.returnToHomePage();
	}

	@Test
	public void testEmptyContactCreation() throws Exception {
		app.navigationHelper.openMainPage();
		app.contactHelper.initNewContactCreation();
		app.contactHelper.fillContactForm(app, this, new ContactData("", "", "", "", "", "", "", "", "", "", "", "", ""));
		app.contactHelper.submitContactCreation();
		app.contactHelper.returnToHomePage();
	}



 
}
