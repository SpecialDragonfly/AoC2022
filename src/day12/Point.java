package day12;

import java.util.ArrayList;

public class Point {
    private final int row;
    private final int column;
    private final int value;

    private int distance = Integer.MAX_VALUE;

    private Point previous = null;

    public Point(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public void reset() {
        this.previous = null;
        this.distance = Integer.MAX_VALUE;
    }

    public int getValue() {
        return this.value;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setPrevious(Point previous) {
        this.previous = previous;
    }

    public ArrayList<Point> getSurroundingPoints(Map map) {
        ArrayList<Point> points = new ArrayList<>();
        // Get North
        Point p = map.get(this.row - 1, this.column);
        if (p != null) {
            int checkingValue = p.getValue();
            int nodeValue = this.getValue();
            if (p.getValue() == 'E') {
                checkingValue = 'z';
            }
            if (p.getValue() == 'S') {
                checkingValue = 's';
            }
            if (nodeValue == 'S') {
                nodeValue = 'a';
            }
            if (checkingValue <= nodeValue + 1) {
                if (p.getDistance() > this.distance + 1) {
                    p.setDistance(this.distance + 1);
                    points.add(p);
                }
            }
        }

        // Get South
        p = map.get(this.row + 1, this.column);
        if (p != null) {
            int checkingValue = p.getValue();
            int nodeValue = this.getValue();
            if (p.getValue() == 'E') {
                checkingValue = 'z';
            }
            if (p.getValue() == 'S') {
                checkingValue = 's';
            }
            if (nodeValue == 'S') {
                nodeValue = 'a';
            }
            if (checkingValue <= nodeValue + 1) {
                if (p.getDistance() > this.distance + 1) {
                    p.setDistance(this.distance + 1);
                    points.add(p);
                }
            }
        }

        // Get East
        p = map.get(this.row, this.column + 1);
        if (p != null) {
            int checkingValue = p.getValue();
            int nodeValue = this.getValue();
            if (p.getValue() == 'E') {
                checkingValue = 'z';
            }
            if (p.getValue() == 'S') {
                checkingValue = 's';
            }
            if (nodeValue == 'S') {
                nodeValue = 'a';
            }
            if (checkingValue <= nodeValue + 1) {
                if (p.getDistance() > this.distance + 1) {
                    p.setDistance(this.distance + 1);
                    points.add(p);
                }
            }
        }

        // Get West
        p = map.get(this.row, this.column - 1);
        if (p != null) {
            int checkingValue = p.getValue();
            int nodeValue = this.getValue();
            if (p.getValue() == 'E') {
                checkingValue = 'z';
            }
            if (p.getValue() == 'S') {
                checkingValue = 's';
            }
            if (nodeValue == 'S') {
                nodeValue = 'a';
            }
            if (checkingValue <= nodeValue + 1) {
                if (p.getDistance() > this.distance + 1) {
                    p.setDistance(this.distance + 1);
                    points.add(p);
                }
            }
        }

        return points;
    }

    public String toString() {
        return (this.row+2)+","+(this.column)+" : " + this.getValue() + " at a distance of " + this.getDistance();
    }
}
