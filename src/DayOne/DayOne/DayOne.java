package DayOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import Util.StringFileReader;

public class DayOne {
	public static void main(String[] args) {
		Vector<String> data = StringFileReader.readFile("./src/DayOne/Data/input.txt");
		List<Integer> calories = new ArrayList<Integer>();
		int elfCarrying = 0;
		for (String line : data) {
			if (line.trim() == "") {
				// New elf
				calories.add(elfCarrying);
				elfCarrying = 0;
				continue;
			}
			elfCarrying += Integer.parseInt(line);			
		}
		Collections.sort(calories);
		Collections.reverse(calories);
		
		System.out.println("Max: " + calories.get(0));
		System.out.println("Sum top 3: " + (calories.get(0) + calories.get(1) + calories.get(2)));
	}
}
