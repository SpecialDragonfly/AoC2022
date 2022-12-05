package day2;

import java.util.Vector;

import Util.StringFileReader;

public class DayTwo {
	public static void main(String[] args) {

		Vector<String> data = StringFileReader.readFile("./src/day2/Data/input.txt");
		// int score = StrategyOne.run(data);
		int score = StrategyTwo.run(data);
		System.out.println("Score: " + score);
	}
}
