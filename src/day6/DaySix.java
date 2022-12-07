package day6;

import java.util.Vector;

public class DaySix {
    public static void main(String[] args) {
        Vector<String> data = Util.StringFileReader.readFile("./src/day6/Data/input.txt");
        String[] letters = data.get(0).split("");
        SpecialQueue q = new SpecialQueue(14);
        for (int i = 0; i < letters.length; i++) {
            q.add(letters[i]);
            if (q.isUnique()) {
                System.out.println("Unique at " + (i+1));
                break;
            }
        }
        System.out.println("Done");

    }
}
