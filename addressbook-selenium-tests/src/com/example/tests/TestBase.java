package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	static ApplicationManager app;//для доступа к ApplicationManager 

	
	
	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}
	
	@AfterTest
	public void tearDown() throws Exception {
	app.stop();	
	}

	@DataProvider
	public Iterator<Object[]>  randomValidGroupGenerator(){
		List<Object[]> List = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
		  GroupData group = new GroupData();
		  group.name = generateRanomString(); 
		  group.header = generateRanomString(); 
		  group.footer = generateRanomString(); 
		  List.add(new Object[] {group});
		}
		return List.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> List = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData();
			contact.lastname = generateRanomString();
			contact.address = generateRanomString();
			contact.hometelephone = generateRanomString();
			contact.mobiletelephone = generateRanomString();
			contact.worktelephone = generateRanomString();
			contact.email = generateRanomString();
			contact.email_2 = generateRanomString();
			contact.secondary_address = generateRanomString();
			contact.secondary_phone = generateRanomString();
			contact.birthyear = generateRanomString();	
			List.add(new Object[]{contact});
		}
		return List.iterator();
	}
	public String generateRanomString(){
		Random rnd = new Random();
		 if(rnd.nextInt(3) == 0) {
			   return "";  
			  } else {
			   return "test" + rnd.nextInt();
			  }
	}

}
