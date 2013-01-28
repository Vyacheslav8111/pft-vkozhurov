package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;

public class TestBase {
        
        static ApplicationManager app;//äëÿ äîñòóïà ê ApplicationManager 

        
        
        @BeforeTest
        public void setUp() throws Exception {
                app = new ApplicationManager();
        }
        
        @AfterTest
        public void tearDown() throws Exception {
        app.stop();     
              
}        

        @DataProvider
	    public Iterator<Object[]> randomValidGroupGenerator() {
	    	List<GroupData> groups = generateRandomGroups(5);
	    	List<Object[]> list = wrapGropsForDataProvider(groups);
	    	
	      return list.iterator();
	    }
	    
	   	
	        
	    private List<Object[]> wrapGropsForDataProvider(List<GroupData> groups) {
	    List<Object[]> list = new ArrayList<Object[]>();
	    for (GroupData group : groups) {
	    	list.add(new Object[]{group});
		}
			return list;
		}

		@DataProvider   
		public Iterator<Object[]> randomValidContactGenerator() {
		      List<Object[]> list = new ArrayList<Object[]>();
		      for (int i = 0; i < 5; i++) {
		    	ContactData contact	= new ContactData()
		    	.withFirstname(generateRandomString())
		    	.withLastname(generateRandomString())
		    	.withAddress(generateRandomString())
		    	.withHometelephone(generateRandomString())
		    	.withMobiletelephone(generateRandomString())
		    	.withWorktelephone(generateRandomString())
		    	.withEmail(generateRandomString())
		    	.withEmail_2(generateRandomString())
		    	.withSecondary_address(generateRandomString())
		    	.withSecondary_phone(generateRandomString())
		    	.withBirthyear(generateRandomString());
		       	list.add(new Object[] {contact});
		      }
		      return list.iterator();
		    } 
		
		 public String generateRandomString() {
		    	Random rnd = new Random();
		    	if (rnd.nextInt(3) == 0) {
			    	return "";	
			    	} else {
			    	return "test" + rnd.nextInt(); 	
			    	}
		 }
}


