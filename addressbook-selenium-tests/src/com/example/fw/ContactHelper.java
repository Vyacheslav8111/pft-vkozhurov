
package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;



public class ContactHelper extends HelperBase {


        

        public ContactHelper(ApplicationManager manager) {
                super(manager);
        }

        public void initNewContactCreation() {
                click(By.linkText("add new"));
        }

        public void fillContactForm(ContactData contact, boolean hasGroupSelector) {
                 type(By.name("firstname"), contact.firstname);
                 type(By.name("lastname"), contact.lastname);
                 type(By.name("address"), contact.address);
                 type(By.name("home"), contact.hometelephone);
                 type(By.name("mobile"), contact.mobiletelephone);
                 type(By.name("work"), contact.worktelephone);
                 type(By.name("email"), contact.email);
                 type(By.name("email2"), contact.email_2);
                 selectByIndex(By.name("bday"), 19);
                 selectByIndex(By.name("bmonth"), 11); 
                 type(By.name("byear"), contact.birthyear);
                 if (hasGroupSelector) {
                                selectByText(By.name("new_group"), "Rob");
                        } else{
                                if (driver.findElements(By.name("new_group")).size() != 0) {
                                        throw new Error ("Group selector exists in contact modification form");
                                }
                        }
                 type(By.name("address2"), contact.secondary_address);
                 type(By.name("phone2"), contact.secondary_phone);
        }


        
        public void submitContactCreation() {
        click(By.name("submit"));
        }

        public void returnToHomePage() {
        click(By.linkText("home page"));
        }

        public void openHomePage() {
        click(By.linkText("home"));
        }

        public void deleteContact(int index) {
        	    selectContactByIndex(index);
                click(By.xpath(".//form[2]/input[2]"));
                
        }

		private void selectContactByIndex(int index) {
			click(By.xpath("//tr[@name = 'entry'][" + (index+1) + "]/td[7]/a/img"));
		}

        public void initContactModification(int index) {
        	selectContactByIndex(index);
                
        }

        public void submitContactModification() {
            click(By.xpath(".//form/input[11]"));
                
        }

		public List<ContactData> getContacts() {
			List<ContactData> contacts = new ArrayList<ContactData>();
			List<WebElement> rows = getContactRows(); 
			for(WebElement row : rows) {
			ContactData contact = new ContactData();
			contact.firstname = getFirstNameInRow(row);
			contact.lastname = getLastNameInRow(row);
			contacts.add(contact);
			}
	
			return contacts;
		}

		

		private String getFirstNameInRow(WebElement row) {
		return row.findElement(By.xpath(".//td[3]")).getText();
		}

		private String getLastNameInRow(WebElement row) {
		return row.findElement(By.xpath(".//td[2]")).getText();
		}

		private List<WebElement> getContactRows() {
			return driver.findElements(By.xpath(".//tr[@name='entry']"));
		}

		

		
		}

		

	

		
	

     


        