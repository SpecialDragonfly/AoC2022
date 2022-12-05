package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class StringFileReader {
	public static Vector<String> readFile(String file) {
		Vector<String> data = new Vector<String>();
	    try {
	        File myObj = new File(file);
	        Scanner myReader = new Scanner(myObj);
	        while (myReader.hasNextLine()) {
	        	data.add(myReader.nextLine());
	        }
	        myReader.close();
	    } catch (FileNotFoundException e) {
	    	// Do nothing
	    	System.out.println(e.getMessage());
	    }
	    return data;
	}
}
