package com.dell.driver;

import java.util.ArrayList;

public class Algorithms {

	public ArrayList<String> inserstionSwap(ArrayList<String> unsortedArray) {
		try {
			String temp = "";
			for (int i = 0; i < unsortedArray.size(); i++) {
				for (int j = 0; j < unsortedArray.size(); j++) {
					if (unsortedArray.get(i).compareToIgnoreCase(unsortedArray.get(j)) < 0) { // can change this to greater then to sort array in descending order ignoring case
																								// while sorting so that array is sorted alphabetically
						temp = unsortedArray.get(i);
						unsortedArray.set(i, unsortedArray.get(j));
						unsortedArray.set(j, temp);
					}

				}
			}
			return unsortedArray;
		} catch (Exception e) {
			System.out.println("An error occured while sorting the files");
		}
		return unsortedArray;
	}
	
	public ArrayList<String> insertionSort(ArrayList<String> unsortedArray) {
		try {
	       int size = unsortedArray.size();  
	        for (int j = 1; j < size; j++) {  
	            String key = unsortedArray.get(j);  
	            int i = j-1;  
	            while ( (i >= 0) && ( unsortedArray.get(i).compareToIgnoreCase(key) > 0 ) ) {  
	                unsortedArray.set(i+1,unsortedArray.get(i));  
	                i--;  
	            }  
	            unsortedArray.set(i+1 ,key);  
	        }
			return unsortedArray;  
		}catch(Exception e) {
			System.out.println("An error occured while sorting the files");
		}
		return unsortedArray;
	}

	public String binarySearch(ArrayList<String> sortedArray, String fileName) {
		try {
		int start = 0;
		int end = sortedArray.size();
		int mid = (start + end) / 2;
		while (start <= end) {
			if (sortedArray.get(mid).compareTo(fileName) < 0) {
				start = mid + 1;
			} else if (sortedArray.get(mid).compareTo(fileName) == 0) {
				System.out.println("element is found at index: " + mid);
				return "The File : " + fileName + " was found";
			} else {
				end = mid - 1;
			}
			mid = (start + end) / 2;
		}
		if (start > end) {
			return "Sorry the File: " + fileName + " was not found please enter a valid file name";
		}
		return "Sorry the File: " + fileName + " was not found please enter a valid file name";
	}
	catch (Exception e ) {
		System.out.println("An error occured while searching for files");
	}
		return "Sorry the File: " + fileName + " was not found please enter a valid file name";
}
}

