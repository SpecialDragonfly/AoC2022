package day9;

public class Head implements Knot {
    private int row;
    private int column;

    public Head(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void move(String direction) {
        switch (direction) {
            case "U" -> this.row--;
            case "D" -> this.row++;
            case "L" -> this.column--;
            case "R" -> this.column++;
        }
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
