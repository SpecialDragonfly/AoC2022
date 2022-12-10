package day10;

import day10.Commands.CommandFactory;

import java.util.ArrayList;
import java.util.Vector;

public class DayTen {
    public static void main(String[] args) {
        Vector<String> data = Util.StringFileReader.readFile("./src/day10/Data/input.txt");
        Crt crt = new Crt(6, 40);
        Machine machine = new Machine(crt);
        for (String line : data) {
            machine.runCommand(CommandFactory.getCommand(line));
        }
        machine.draw();
    }
}
