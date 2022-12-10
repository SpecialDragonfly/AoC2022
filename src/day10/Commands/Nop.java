package day10.Commands;

public class Nop implements CommandInterface {
    int cycles = 1;

    @Override
    public int getCycles() {
        return this.cycles;
    }

    public String toString() {
        return "Noop";
    }
}
