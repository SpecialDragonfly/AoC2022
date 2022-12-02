package DayTwo;

import java.util.HashMap;
import java.util.Vector;

public class StrategyOne {
	public static int run(Vector<String> data) {
		HashMap<String, Integer> options = new HashMap<String, Integer> ();
		options.put("A", 1); // Rock
		options.put("B", 2); // Paper
		options.put("C", 3); // Scissors
		options.put("X", 1); // Rock
		options.put("Y", 2); // Paper
		options.put("Z", 3); // Scissors
		
		int score = 0;
		for (String game : data) {
			String[] parts = game.split(" ");
			int them = options.get(parts[0]);
			int us = options.get(parts[1]);
			System.out.print("Them: "+ them + " Us: " + us + " => ");
			
			// Score because we lost/won/draw
			int tempScore = 0;
			if (them == us) {
				tempScore += 3;
			} else if (us > them) {
				if (us == 3 && them == 1) {
				} else {
					// won
					tempScore += 6;
				}
			} else if (them > us) {
				if (them == 3 && us == 1) {
					// won
					tempScore += 6;
				}
			}
			
			// Score because of what we played
			tempScore += us;
			score += tempScore;
		}
		return score;
	}
}
