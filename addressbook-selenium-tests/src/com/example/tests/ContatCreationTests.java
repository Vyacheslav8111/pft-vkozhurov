package com.example.tests;




import static com.example.tests.ContactDataGenerator.LoadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.LoadContactsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;



public class ContatCreationTests extends TestBase{
        
	@DataProvider   
	public Iterator<Object[]> contactsFromFile() throws IOException{
		return wrapContactsForDataProvider(LoadContactsFromXmlFile(new File ("contacts.xml"))).iterator();
	    } 
        
       

		@Test(dataProvider = "contactsFromFile")
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