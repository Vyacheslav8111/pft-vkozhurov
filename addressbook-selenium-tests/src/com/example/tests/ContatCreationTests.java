package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContatCreationTests extends TestBase{
        
    
	
        @Test(dataProvider = "randomValidContactGenerator")
        public void testContactCreationWithValidData(ContactData contact) throws Exception {
                app.getNavigationHelper().openMainPage();
                app.getContactHelper().openHomePage(); 
                
                // save old state
                List<ContactData> oldList = app.getContactHelper().getContacts();
                
                // action
                
                app.getContactHelper().initNewContactCreation();
                app.getContactHelper().fillContactForm(contact, true);
                app.getContactHelper().submitContactCreation();
                app.getContactHelper().returnToHomePage();
                
              //save new state
                List<ContactData> newList = app.getContactHelper().getContacts();

             //compare states
                assertEquals(newList.size(), oldList.size() + 1);
               
                oldList.add(contact);
                Collections.sort(oldList);
                assertEquals(newList, oldList);
        }

     
}