package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContatCreationTests extends TestBase{
        
        
        @Test
        public void testNonEmptyContactCreation() throws Exception {
                app.getNavigationHelper().openMainPage();
                app.getContactHelper().openHomePage(); 
                
                // save old state
                List<ContactData> oldList = app.getContactHelper().getContacts();
                
                // action
                
                app.getContactHelper().initNewContactCreation();
                ContactData contact = new ContactData();
                contact.firstname = "newname";
                contact.lastname = "aaa";
                contact.address = "8787";
                contact.hometelephone = "887776";
                contact.mobiletelephone = "7654";
                contact.worktelephone = "565656";
                contact.email = "@866";
                contact.email_2 = "65";
                contact.secondary_address = "yty";
                contact.secondary_phone = "655443";
                contact.birthyear = "1981";
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


         @Test
     public void testEmptyContactCreation() throws Exception {
             app.getNavigationHelper().openMainPage();
             
             // save old state
             List<ContactData> oldList = app.getContactHelper().getContacts();
             
             // action
             
             ContactData contact = new ContactData("", "", "", "", "", "", "", "", "", "", "");
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