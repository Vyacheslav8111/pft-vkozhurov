package com.example.tests;

import org.testng.annotations.Test;



public class GroupCreationTests extends TestBase {
	@Test
	public void testEmtpyGroupCreation() throws Exception {
		app.openMainPage();
		app.gotoGroupsPage();
		app.initGroupCreation();
		GroupData group = new GroupData();
		group.name = "name 1";
		group.header = "header 1";
		group.footer = "footer 1";
		app.fillGroupsForm(this, group);
		app.submitGroupCreation();
		app.returnToGroupsPage();
	}
	
	@Test
	public void testNonEmtpyGroupCreation() throws Exception {
		app.openMainPage();
		app.gotoGroupsPage();
		app.initGroupCreation();
		app.fillGroupsForm(this, new GroupData("", "", ""));
		app.submitGroupCreation();
		app.returnToGroupsPage();
	}
}
