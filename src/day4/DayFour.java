package day4;

import java.util.Vector;

public class DayFour {
	public static void main(String[] args) {
		System.out.println("here");
		Vector<String> data = Util.StringFileReader.readFile("./src/day4/Data/input.txt");
		int count = 0;
		for (String line : data) {
			System.out.println(line);
			String[] parts = line.split(",");
			Pair p = new Pair(parts[0], parts[1]);
			// Switch if statements for part 1 and part 2.
			if (p.fullyOverlaps()) {
				count++;
			}
			if (p.overlapAtAll()) {
				count++;
			}
		}
		System.out.println("Count: "+ count);
	}
}
