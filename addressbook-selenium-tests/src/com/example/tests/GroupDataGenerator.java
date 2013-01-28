package com.example.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupDataGenerator {


	public static void main(String[] args) {
	  if (args.length < 3) {
		  System.out.println("please specify parametrs: <amount of test data> <file> <format>");
		  return;
	  }
	  
	  int amount = Integer.parseInt(args[0]);
	  File file = new File(args[1]);
	  String format = args[2];
	  
	  List<GroupData> groups = generateRandomGroups(amount);
	  if ("csv".equals(format)) {
		  saveGroupsToCsvFile(groups, file);
	  } else if ("xml".equals(format)) {
		  saveGroupsToXmlFile(groups, file);
	  }	  else { System.out.println("Unknown format " + format);
	  return;
		  }
	  }

	private static void saveGroupsToXmlFile(List<GroupData> groups, File file) {
		// TODO Auto-generated method stub
		
	}

	private static void saveGroupsToCsvFile(List<GroupData> groups, File file) {
		// TODO Auto-generated method stub
		
	}

	public static List<GroupData> generateRandomGroups(int amount) {
		List<GroupData> list = new ArrayList<GroupData>();
	      for (int i = 0; i < amount; i++) {
	    	GroupData group	= new GroupData()
	    	.withName(generateRandomString())
	    	.withHeader(generateRandomString())
	    	.whithFooter(generateRandomString());
	    	list.add(group);
	      }
	      return list;
	} 
	 
	public static String generateRandomString() {
    	Random rnd = new Random();
    	if (rnd.nextInt(3) == 0) {
	    	return "";	
	    	} else {
	    	return "test" + rnd.nextInt(); 	
	    	}
          }
	  
	}

