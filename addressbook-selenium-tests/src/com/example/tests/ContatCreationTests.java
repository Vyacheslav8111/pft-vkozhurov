package com.example.tests;

import org.testng.annotations.Test;

public class ContatCreationTests extends TestBase{
	
	
	@Test
	public void testNonEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openHomePage(); 
		app.getContactHelper().initNewContactCreation();
		
		ContactData contact = new ContactData();
		contact.firstname = "asd";
		contact.lastname = "cv";
		contact.address = "8787";
		contact.hometelephone = "887776";
		contact.mobiletelephone = "7654";
		contact.worktelephone = "565656";
		contact.email = "@866";
		contact.email_2 = "65";
		contact.secondary_address = "yty";
		contact.secondary_phone = "655443";
		contact.birthyear = "1981";
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
