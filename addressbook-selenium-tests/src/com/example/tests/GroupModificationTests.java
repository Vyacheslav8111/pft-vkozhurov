package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test
	public void modifySomeGroup() {
		app.getNavigationHelper().openMainPage(); 
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupModifycation(1);
		GroupData group = new GroupData();
		group.name = "new name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModifycation(1);
		app.getGroupHelper().returnToGroupsPage();
	}
}
