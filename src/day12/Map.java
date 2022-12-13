package day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;

public class Map {
    private HashMap<String, Point> map;
    private String source = "";
    private int maxHeight;
    private int maxWidth;

    public Map(int maxHeight, int maxWidth) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        this.map = new HashMap<>();
    }

    public Point get(int row, int column) {
        return this.map.get(row+","+column);
    }

    public void addRow(int index, String row) {
        for (int i = 0; i < row.length(); i++) {
            this.map.put(index+","+i, new Point(index, i, row.charAt(i)));
            if (row.charAt(i) == 'S') {
                source = index+","+i;
            }
        }
    }

    public void output() {
        for (int row = 0; row < this.maxHeight; row++) {
            for (int column = 0; column < this.maxWidth; column++) {
                System.out.print(this.map.get(row+","+column).getDistance()+",");
            }
            System.out.println();
        }
    }

    public void run() {
        // foreach node in map, set distance to infinity
        // foreach node in map, set previous to null

        // Start at the source
        Point source = this.map.get(this.source);
        source.setDistance(0);

        ArrayList<Point> points = new ArrayList<>(source.getSurroundingPoints(this));

        while (points.size() > 0) {
            Point p = points.remove(0);
            points.addAll(p.getSurroundingPoints(this));
            if (p.getValue() == (int)'E') {
                System.out.println("Found a solution. Length: " + p.getDistance());
            }
        }
    }

    public void runPart2() {
        ArrayList<Point> possibleSources = new ArrayList<>();
        for (int i = 0; i < this.maxHeight; i++) {
            for (int j = 0; j < this.maxWidth; j++) {
                Point p = this.map.get(i+","+j);
                if (p.getValue() == 'a' || p.getValue() == 'S') {
                    possibleSources.add(p);
                }
            }
        }

        ArrayList<Integer> lengths = new ArrayList<>();
        for (Point source : possibleSources) {
            source.setDistance(0);
            ArrayList<Point> points = new ArrayList<>(source.getSurroundingPoints(this));

            while (points.size() > 0) {
                Point p = points.remove(0);
                points.addAll(p.getSurroundingPoints(this));
                if (p.getValue() == (int) 'E') {
                    lengths.add(p.getDistance());
                    System.out.println("Found a solution. Length: " + p.getDistance());
                }
            }
            this.reset();
        }
        System.out.println(lengths.stream().sorted().findFirst() + " is the lowest");
    }

    public void reset() {
        this.map.forEach((k, v) -> {
            v.reset();
        });
    }
}
