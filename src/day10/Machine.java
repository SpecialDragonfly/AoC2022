package day10;

import day10.Commands.Addx;
import day10.Commands.CommandInterface;

import java.util.ArrayList;

public class Machine {
    private int register = 1;

    private final Crt display;

    private int cycle = 0;

    public Machine(Crt display) {
        this.display = display;
    }

    public void runCommand(CommandInterface command) {
        int commandCycles = command.getCycles();
        for (int i = 0; i < commandCycles; i++) {
            this.display.draw(this.cycle, this.register);
            this.cycle++;
        }
        if (command instanceof Addx) {
            this.register = this.register + ((Addx) command).getNumberToAdd();
        }
    }

    public void draw() {
        this.display.output();
    }
}
