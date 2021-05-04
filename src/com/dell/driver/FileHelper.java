package com.dell.driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileHelper {
	
	private Writer output;
	
	private final String userFile = "UsersFiles.txt";
	
	BufferedReader reader;
	
	
	public String addFile(String fileName) {
		
		try {	
		output = new BufferedWriter(new FileWriter(userFile,true));
		output.append(fileName + "\n");
		output.close();
		return "File successfully added to system";
		}
		
		catch(Exception e) {
			System.out.println("The system is currently experiencing problems please try again later");
		}
		return "There was an issue adding File";	
	}
	
	
	public String deleteFile(String fileName) {
		try {
			 //Reading File Content and storing it to a StringBuilder variable ( skips lineToRemove)
		    StringBuilder sb = new StringBuilder();
		    File file = new File(userFile);
		    try (Scanner sc = new Scanner(file)) {
		        String currentLine;
		        while(sc.hasNext()){
		            currentLine = sc.nextLine();
		            if(currentLine.equals(fileName)){
		                continue; //skips lineToRemove
		            }
		            sb.append(currentLine).append("\n");
		        }
		    }
		    BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
		    writer.append(sb.toString());
		    writer.close();
		    return "File " + fileName + " removed  from system";
		}
		catch(Exception e) {
			
		}
		return "There was an issue deleting the file";
	}
	
	public ArrayList<String> getAllFiles() {
		try {
			reader = new BufferedReader (new FileReader(userFile)); 
			String line = reader.readLine();
			ArrayList<String> allFiles = new ArrayList<String>();
			while(line != null) {
				allFiles.add(line);
				line = reader.readLine();
			}
			reader.close();	
			 Collections.sort(allFiles);
			 return allFiles;
		}
		catch(Exception e) {
			System.out.println("The system is currently experiencing problems please try again later");
		}
		return null;
		
	}
	
	public void printAllFiles(ArrayList<String> allFiles){
		 for(String file:allFiles) {
	            System.out.println(file);
	        }
	}
		
}
