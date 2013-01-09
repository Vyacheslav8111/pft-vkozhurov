
package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;



public class ContactHelper extends HelperBase {
	     
	    public static boolean CREATION = true;
	    public static boolean MODIFICATION = false;

        

        public ContactHelper(ApplicationManager manager) {
                super(manager);
        }

        public ContactHelper initNewContactCreation() {
                click(By.linkText("add new"));
                return this;
        }

        public ContactHelper fillContactForm(ContactData contact, boolean formType) {
                 type(By.name("firstname"), contact.getFirstname() );
                 type(By.name("lastname"), contact.getLastname());
                 type(By.name("address"), contact.getAddress());
                 type(By.name("home"), contact.getHometelephone());
                 type(By.name("mobile"), contact.getMobiletelephone());
                 type(By.name("work"), contact.getWorktelephone());
                 type(By.name("email"), contact.getEmail());
                 type(By.name("email2"), contact.getEmail_2());
                 selectByIndex(By.name("bday"), 19);
                 selectByIndex(By.name("bmonth"), 11); 
                 type(By.name("byear"), contact.getBirthyear());
                 if (formType == CREATION) {
                                selectByText(By.name("new_group"), "Rob");
                        } else{
                                if (driver.findElements(By.name("new_group")).size() != 0) {
                                        throw new Error ("Group selector exists in contact modification form");
                          }
                        }
                 type(By.name("address2"), contact.getSecondary_address());
                 type(By.name("phone2"), contact.getSecondary_phone());
                 return this;
        }


        
        public ContactHelper submitContactCreation() {
        click(By.name("submit"));
        return this;
        }

        public ContactHelper returnToHomePage() {
        click(By.linkText("home page"));
        return this;
        }

        public ContactHelper openHomePage() {
        click(By.linkText("home"));
        return this;
        }

        public ContactHelper deleteContact(int index) {
                    selectContactByIndex(index);
                click(By.xpath(".//form[2]/input[2]"));
                return this;
                
        }

                private void selectContactByIndex(int index) {
                        click(By.xpath("//tr[@name = 'entry'][" + (index+1) + "]/td[7]/a/img"));
                }

        public ContactHelper initContactModification(int index) {
             selectContactByIndex(index);
             return this;
                
        }

        public ContactHelper submitContactModification() {
            click(By.xpath(".//form/input[11]"));
            return this;
                
        }

                public List<ContactData> getContacts() {
                        List<ContactData> contacts = new ArrayList<ContactData>();
                        List<WebElement> rows = getContactRows(); 
                        for(WebElement row : rows) {
                       String firstname = getFirstNameInRow(row);
                       String lastname = getLastNameInRow(row);
                        contacts.add(new ContactData()
                        .withFirstname(firstname)
                        .withLastname(lastname));
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
