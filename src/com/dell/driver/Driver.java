package com.dell.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
	
	
	static String menu = "\nPlease select an option from our list. The options being 1, 2 or 3" +
		    "\na. Add a file to our repository " +
			"\nb.  Search a file from our repository "+
		    "\nc. Delete a file from our repository"+
			"\nPrease q to quit application" ;

	public static void main(String[] args) {
	
		System.out.println("This service was created by Mark O Donoghue "+
		"/n This service allows a user to add a file search for files and delete files");		
		String userOption = null;
		 FileHelper file = new FileHelper();
		
		while(userOption != "q")
		{
			
			 System.out.println(menu);
			 Scanner userInput = new Scanner(System.in);
			
			 userOption = userInput.nextLine();
			
			if (userOption.equals("a")) {
				System.out.println("Please enter the name of the file you wish to Add");
			    String fileName = userInput.nextLine();
			    System.out.println(file.addFile(fileName));
			    userOption = null;
			}
			
			else if (userOption.equals("b")) {
				System.out.println("Returning a sorted list of all files");
				ArrayList <String> allFiles = file.getAllFiles();	
				file.printAllFiles(allFiles);
				userOption = null;
			}
			
			else if (userOption.equals("c")) {
				System.out.println("Please enter the name of the file you wish to Delete");
			    String fileName = userInput.nextLine();
			    System.out.println(file.deleteFile(fileName));
				userOption = null;
			}
			
			else if (userOption.equals("q")) {
				System.out.println("You have chosen to close the application");
			    String fileName = userInput.nextLine();
			    System.out.println(file.deleteFile(fileName));
				userOption = null;
			}
			
			else {
				System.out.println("Thank you for using the application for more information on the service contact developer Mark O Donoghue");
				userOption = null;
			}
			
		}
		
		System.out.println("Thank you for using the application");
	}

}
