package day9;

import java.util.HashSet;

public class Tail implements Knot {
    private final HashSet<String> history;
    private int row;
    private int column;

    public Tail(int row, int column) {

        this.row = row;
        this.column = column;
        this.history = new HashSet<>();
    }

    public void move(Knot knot) {
        // if Head is within the area row-1 > row+1 and column-1 > column+1 then no movement necessary.
        if (this.row-1 <= knot.getRow() && this.row+1 >= knot.getRow()
            && this.column-1 <= knot.getColumn() && this.column+1 >= knot.getColumn()
        ) {
            //System.out.println("(" + this.row + ", " + this.column + ") Tail did not move.");
            return;
        }

        // if Head is the same row but different column, move towards head
        if (this.row == knot.getRow()) {
            // Do we need to increase or decrease the column?
            if (this.column < knot.getColumn()) {
                this.column++;
            } else {
                this.column--;
            }
            //System.out.println("(" + this.row + ", " + this.column + ") Tail moved horizontally.");
        }

        // if Head is the same column, but different row, move towards head
        if (this.column == knot.getColumn()) {
            // Do we need to increase or decrease the row?
            if (this.row < knot.getRow()) {
                this.row++;
            } else {
                this.row--;
            }
            //System.out.println("(" + this.row + ", " + this.column + ") Tail moved vertically.");
        }

        // if Head is further away and not row or column then we need to move diagonally.
        if (this.column != knot.getColumn() && this.row != knot.getRow()) {
            if (this.row < knot.getRow()) {
                this.row++;
            } else {
                this.row--;
            }
            if (this.column < knot.getColumn()) {
                this.column++;
            } else {
                this.column--;
            }
            //System.out.println("(" + this.row + ", " + this.column + ") Tail moved diagonally.");
        }
        this.history.add(this.row+","+this.column);
    }

    public int uniqueLocations() {
        return this.history.size() + 1;
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getColumn() {
        return this.column;
    }
}
