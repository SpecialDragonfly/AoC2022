package day10;

import java.util.Arrays;

public class Crt {
    private final String[] display;

    public Crt(int rows, int columns) {
        this(rows, columns, ".");
    }

    public Crt(int rows, int columns, String value) {
        this.display = new String[rows * columns];
        Arrays.fill(this.display, value);
    }

    public void output() {
        for (int i = 0; i < this.display.length; i++) {
            if (i % 40 == 0) {
                System.out.println();
            }
            System.out.print(this.display[i]);
        }
        System.out.println();
    }

    public void draw(int cycle, int register) {
        int currentRow = Math.floorDiv(cycle, 40);
        int drawnCycle = cycle - (40 * currentRow);
        if (drawnCycle >= register - 1 && drawnCycle <= register + 1) {
            this.display[cycle] = "#";
        } else {
            this.display[cycle] = " ";
        }
    }
}
