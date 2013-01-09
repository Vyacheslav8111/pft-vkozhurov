package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import static com.example.fw.ContactHelper.MODIFICATION;
import org.testng.annotations.Test;


public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator") 
	public void modifySomeContact(ContactData contact) {
		 // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();
        
        Random rnd  = new Random();
        int index = rnd.nextInt(oldList.size() - 1);
        
        // action
        app.getContactHelper()
        .initContactModification(index)
        .fillContactForm(contact, MODIFICATION)
        .submitContactModification()
        .returnToHomePage();
        
		 //save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

       //compare states
    
       
        oldList.remove(index);
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);

}
}
