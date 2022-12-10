package day10;

import java.util.Arrays;

public class Crt {
    private final String[] display;
    private int currentRow;
    private int rows;
    private int columns;

    public Crt(int rows, int columns) {

        this.rows = rows;
        this.columns = columns;
        this.currentRow = -1;

        this.display = new String[rows * columns];
        Arrays.fill(this.display, ".");
    }

    public void output() {
        for (int i = 1; i <= this.display.length; i++) {
            System.out.print(this.display[i - 1]);
            if (i % 40 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void draw(int cycle, int register) {
        if (cycle % 40 == 0) {
            this.currentRow++;
        }
        int drawnCycle = cycle - (40 * this.currentRow);
        if (drawnCycle == register - 1 || drawnCycle == register || drawnCycle == register + 1) {
            this.display[cycle] = "#";
        } else {
            this.display[cycle] = " ";
        }
    }
}
