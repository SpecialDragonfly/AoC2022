package day10.Commands;

public class Addx implements CommandInterface {
    int cycles = 2;
    private final int numberToAdd;

    public Addx(int numberToAdd) {

        this.numberToAdd = numberToAdd;
    }

    public int getCycles() {
        return this.cycles;
    }

    public int getNumberToAdd() {
        return this.numberToAdd;
    }

    public String toString() {
        return "Addx " + this.numberToAdd;
    }
}
