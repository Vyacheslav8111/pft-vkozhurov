package com.example.tests;



public class GroupCreationTests extends TestBase {
	@org.testng.annotations.Test
	public void testEmtpyGroupCreation() throws Exception {
		openMainPage();
		gotoGroupsPage();
		initGroupCreation();
		GroupData group = new GroupData();
		group.name = "name 1";
		group.header = "header 1";
		group.footer = "footer 1";
		fillGroupsForm(group);
		submitGroupCreation();
		returnToGroupsPage();
	}
	
	@org.testng.annotations.Test
	public void testNonEmtpyGroupCreation() throws Exception {
		openMainPage();
		gotoGroupsPage();
		initGroupCreation();
		fillGroupsForm(new GroupData("", "", ""));
		submitGroupCreation();
		returnToGroupsPage();
	}
}
