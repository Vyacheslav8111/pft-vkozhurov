package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	

	@Test
	public void test1NonEmpryContactCreation() throws Exception {
		app.openMainPage();
		app.gotoAddNewPages();
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
		app.fillContactForm(this, contact);
		app.submitContactCreation();
		app.returnToHomePages();
	}
	
	@Test
	public void test1EmpryContactCreation() throws Exception {
		app.openMainPage();
		app.gotoAddNewPages();
		app.fillContactForm(this, new ContactData("", "", "", "", "", "", "", "", "", "", ""));
		app.submitContactCreation();
	    app.returnToHomePages();
	}
	}

