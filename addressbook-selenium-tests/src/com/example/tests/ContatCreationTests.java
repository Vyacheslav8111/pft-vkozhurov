package com.example.tests;

import org.testng.annotations.Test;

public class ContatCreationTests extends TestBase{
	
	
	@Test
	public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openHomePage(); 
		app.getContactHelper().initNewContactCreation();
		ContactData contact = new ContactData();
		contact.firstname = "firstname 1";
		contact.lastname = "lastname 1";
		contact.address = "address 1";
		contact.hometelephone = "hometelephone 1";
		contact.mobiletelephone = "mobiletelephone 1";
		contact.worktelephone = "worktelephone 1";
		contact.email = "email 1";
		contact.email_2 = "email_2 1";
		contact.birthyear = "birthyear1";
		contact.secondary_address = "secondary_address 1";
		contact.secondary_phone = "secondary_phone";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
	}

	@Test
	public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initNewContactCreation();
		app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "", "", "", "", ""));
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
	}



 
}
