package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

        @Test(dataProvider = "randomValidGroupGenerator")
        public void modifySomeGroup(GroupData group) {          
                // save old state
                List<GroupData> oldList = app.getGroupHelper().getGroups();
                
                Random rnd  = new Random();
                int index = rnd.nextInt(oldList.size() - 1);
                
                // action
                app.getGroupHelper().modifyGroup(index,group ); 
                                
                // save new state
                List<GroupData> newList = app.getGroupHelper().getGroups();
                    
                // compare states  
                oldList.remove(index);
                oldList.add(group);
                Collections.sort(oldList);
                assertEquals(newList, oldList);
        }
}