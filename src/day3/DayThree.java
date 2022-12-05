package day3;

import java.util.Vector;

public class DayThree {
	public static void main(String[] args) {
		Vector<String> data = Util.StringFileReader.readFile("./src/day3/Data/input.txt");
		System.out.println("Score: " + DayThree.firstPart(data));
		System.out.println("Group: " + DayThree.secondPart(data));
	}
	
	public static Integer firstPart(Vector<String> data) {
		int score = 0;
		for (String line : data) {
			// Split the line in half
			String firsthalf = line.substring(0, line.length() / 2);
			String secondhalf = line.substring(line.length() / 2);
			Rucksack r = new Rucksack(firsthalf, secondhalf);
			score += r.getValue();
		}
		return score;
	}
	
	public static Integer secondPart(Vector<String> data) {
		int score = 0;
		for (int i = 0; i < data.size(); i+=3) {
			String first = data.get(i);
			String second = data.get(i+1);
			String third = data.get(i+2);
			Group g = new Group(first, second, third);
			score += g.getValue();
		}
		return score;
	}
}
