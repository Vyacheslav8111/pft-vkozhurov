package com.example.tests;


import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;


import static com.example.fw.ContactHelper.CREATION;


public class ContatCreationTests extends TestBase{
        
    
        
        @Test(dataProvider = "randomValidContactGenerator")
        public void testContactCreationWithValidData(ContactData contact) throws Exception {
              
                ContactHelper contactHelper = app.getContactHelper();
				contactHelper.openHomePage(); 
                
                // save old state
                List<ContactData> oldList = contactHelper.getContacts();
                
                // action
                app.getContactHelper()
                .initNewContactCreation()
                .fillContactForm(contact, CREATION)
                .submitContactCreation()
                .returnToHomePage();
                
              //save new state
                List<ContactData> newList = contactHelper.getContacts();

             //compare states
                assertEquals(newList.size(), oldList.size() + 1);
               
                oldList.add(contact);
                Collections.sort(oldList);
                assertEquals(newList, oldList);
        }

     
}