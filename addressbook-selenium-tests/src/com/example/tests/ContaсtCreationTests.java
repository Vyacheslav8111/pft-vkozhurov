package com.example.tests;


import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;




public class ContañtCreationTests extends TestBase{
	
	
	
	public String generateRandomString() {
		Random rnd = new Random();
		if(rnd.nextInt(5) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
		
	}
	
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testContactCreationWithValidData(ContactData contact) throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openHomePage(); 
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		// actions
		app.getContactHelper().initNewContactCreation();
	    app.getContactHelper().fillContactForm(contact, true);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
		
		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
				
		// compare states
		oldList.add(contact);
		Collections.sort(oldList);
		Assert.assertEquals(newList, oldList);
	}


      
}
