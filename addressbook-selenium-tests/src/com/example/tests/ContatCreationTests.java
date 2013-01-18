package com.example.tests;



import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;



public class ContatCreationTests extends TestBase{
        
    
        
        @Test(dataProvider = "randomValidContactGenerator")
        public void testContactCreationWithValidData(ContactData contact) throws Exception {
              
                ContactHelper contactHelper = app.getContactHelper();
			
                
                // save old state
                SortedListOf<ContactData> oldList = contactHelper.getContacts();
                
                // action
                app.getContactHelper().createContact(contact);
                
                
              //save new state
                SortedListOf<ContactData> newList = contactHelper.getContacts();

             //compare states
                assertThat(newList, equalTo(oldList.withAdded(contact)));        
        }

     }