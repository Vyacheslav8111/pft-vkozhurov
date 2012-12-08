package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
        

        @Test
        public void test1NonEmpryContactCreation() throws Exception {
                app.getNavigationHelper().openMainPage();
                app.getContactHelper().gotoAddNewPages();
                ContactData contact = new ContactData();
                contact.firstname = "firstname 1";
                contact.lastname = "lastname 1";
                contact.address = "address 1";
                contact.home = "home 1";
                contact.mobile = "mobile 1";
                contact.work = "work 1";
                contact.email = "email 1";
                contact.email2 = "email2 1";
                contact.byear = "byear 1";
                contact.address2 = "address2 1";
                contact.phone2 = "phone2 1";
                app.getContactHelper().fillContactForm(app, this, contact);
                app.getContactHelper().submitContactCreation();
                app.getContactHelper().returnToHomePages();
        }
        
        @Test
        public void test1EmpryContactCreation() throws Exception {
                app.getNavigationHelper().openMainPage();
                app.getContactHelper().gotoAddNewPages();
                app.getContactHelper().fillContactForm(app, this, new ContactData("", "", "", "", "", "", "", "", "", "", ""));
                app.getContactHelper().submitContactCreation();
                app.getContactHelper().returnToHomePages();
        }
        }
