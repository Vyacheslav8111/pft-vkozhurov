package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;


public class ContactModificationTests extends TestBase {
	
	@Test 
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openHomePage(); 
		
		 // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();
        
        // action
		
		app.getContactHelper().initContactModification(0);
		ContactData contact = new ContactData();
		contact.lastname = "new_name";
		app.getContactHelper().fillContactForm(contact, false);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
		 //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

       //compare states
    
       
        oldList.remove(0);
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);

}
}
