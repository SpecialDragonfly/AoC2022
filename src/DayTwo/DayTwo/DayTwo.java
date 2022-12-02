package DayTwo;

import java.util.Vector;

import Util.StringFileReader;

public class DayTwo {
	public static void main(String[] args) {

		Vector<String> data = StringFileReader.readFile("./src/DayTwo/Data/input.txt");
		// int score = StrategyOne.run(data);
		int score = StrategyTwo.run(data);
		System.out.println("Score: " + score);
	}
}
