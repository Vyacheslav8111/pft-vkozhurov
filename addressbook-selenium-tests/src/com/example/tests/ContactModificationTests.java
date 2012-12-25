package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test 
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openHomePage(); 
		app.getContactHelper().initContactModification(37);
		ContactData contact = new ContactData();
		contact.firstname = "new_name";
		app.getContactHelper().fillContactForm(contact, false);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();

}
}
