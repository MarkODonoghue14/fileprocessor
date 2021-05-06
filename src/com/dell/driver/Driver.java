package com.dell.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
	
	static String MainMenu = "\n Please select an option from below being l or m" +
			"\nl. List all files in the repository " +
			"\nm. add, search for or delete file" +
			"\nq. To quit the application";
	
	
	static String menu = "\nPlease select an option from our list. The options being a, b or c" +
		    "\na. Add a file to our repository " +
			"\nb. Search a file from our repository "+
		    "\nc. Delete a file from our repository"+
			"\nr, to return to main menu" ;

	public static void main(String[] args) {
		try {
	
		System.out.println("This service(File Processor) was created by Mark O Donoghue "+
		"/n This service allows a user to add a file search for files and delete files");		
		String userOption = null;
		 FileHelper file = new FileHelper();
		 
		while(userOption != "q") {
			
			 System.out.println(menu);
			 Scanner userInputMenu = new Scanner(System.in);
			
			 userOption = userInputMenu.nextLine();
			 
			 if (userOption.equals("l")) {
                    System.out.println("Getting all the files stored in the service: " );					
				    file.getAllFile();
				    userOption = null;
				}
			 
			 else if (userOption == "q") {
					System.out.println("You have chosen to close the application");
					break;
			 }
			 
			 else if (userOption == "m") {
		
		while(userOption != "r")
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
				System.out.println("Please enter the name of the file that you wish to search for");
				String fileName = userInput.nextLine();
				String userMessage = file.getFile(fileName);
				System.out.println(userMessage);
				userOption = null;
			}
			
			else if (userOption.equals("c")) {
				System.out.println("Please enter the name of the file you wish to Delete");
			    String fileName = userInput.nextLine();
			    int deletion =file.deleteFile(fileName);
			    if (deletion > 0) {
			    	System.out.println("File: " + fileName + " was successfully deleted");
			    }
			    
			    else{
			    	System.out.println("File: " + fileName + " is not a valid file name please try again with a valid file name");
			    }
				userOption = null;
			}
			
			else if (userOption.equals("q")) {
				System.out.println("You have chosen to close the application");
				break;
			}
			
			else {
				System.out.println("Sorry this was not a valid option please look at the options provided carefully");
				userOption = null;
			}
		}
			
		}
		System.out.println("Returning to main menu");
		System.out.println("Thank you for using the application for more information on the service contact developer Mark O Donoghue");
	}
		}
	catch(Exception e) {
		System.out.println("An issue occured while using the application");
	}
		
	}

}
