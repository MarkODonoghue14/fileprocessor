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
	
	Algorithms algorithms = new Algorithms();
	
	
	
	
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
	
	
	public int deleteFile(String fileName) {
		try {
			int count = 0;
		    StringBuilder sb = new StringBuilder();
		    File file = new File(userFile);
		    try (Scanner sc = new Scanner(file)) {
		        String currentLine;
		        while(sc.hasNext()){
		            currentLine = sc.nextLine();
		            if(currentLine.toUpperCase().equals(fileName.toUpperCase()))
		            {
		            	count++;
		                continue; 
		            }
		            sb.append(currentLine).append("\n");
		        }
		    }
		    BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
		    writer.append(sb.toString());
		    writer.close();
		    return count;
		}
		catch(Exception e) {
			System.out.println("The system is currently experiencing problems please try again later");		
		}
		return 0;
	}
	
	public String getFile(String fileName) {
		try {
			reader = new BufferedReader (new FileReader(userFile)); 
			String line = reader.readLine();
			ArrayList<String> allFiles = new ArrayList<String>();
			while(line != null) {
				allFiles.add(line);
				line = reader.readLine();
			}
			reader.close();
			 algorithms.inserstionSwap(allFiles);
			 printAllFiles(allFiles);
			 String userMessage = algorithms.binarySearch(allFiles, fileName);
			 return userMessage;
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
