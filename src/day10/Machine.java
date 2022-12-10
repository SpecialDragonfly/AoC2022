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
        //System.out.println("Begin executing " + command.toString());
        for (int i = 0; i < commandCycles; i++) {
            //System.out.println("Drawing at pixel " + this.cycle);
            this.display.draw(this.cycle, this.register);
            this.cycle++;
            //this.display.output();
        }
        if (command instanceof Addx) {
            this.register = this.register + ((Addx) command).getNumberToAdd();
        }
        //System.out.println("Finish executing " + command.toString() + " Register is now " + this.register);
    }

    public void draw() {
        this.display.output();
    }
}
