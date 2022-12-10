package day9;

import java.util.Vector;

public class DayNine {
    public static void main(String[] args) {
        Vector<String> data = Util.StringFileReader.readFile("./src/day9/Data/input.txt");
        Head head = new Head(0, 0);
        Tail knot1 = new Tail(0, 0);
        Tail knot2 = new Tail(0, 0);
        Tail knot3 = new Tail(0, 0);
        Tail knot4 = new Tail(0, 0);
        Tail knot5 = new Tail(0, 0);
        Tail knot6 = new Tail(0, 0);
        Tail knot7 = new Tail(0, 0);
        Tail knot8 = new Tail(0, 0);
        Tail tail = new Tail(0, 0);
        for (String line : data) {
            String[] parts = line.split(" ");
            String direction = parts[0];
            int times = Integer.parseInt(parts[1]);
            for (int i = 0; i < times; i++) {
                head.move(direction);
                knot1.move(head);
                knot2.move(knot1);
                knot3.move(knot2);
                knot4.move(knot3);
                knot5.move(knot4);
                knot6.move(knot5);
                knot7.move(knot6);
                knot8.move(knot7);
                tail.move(knot8);
            }
        }
        System.out.println("Unique locations: " + tail.uniqueLocations());
    }
}
