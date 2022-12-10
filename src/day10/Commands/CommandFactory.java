package day10.Commands;

public class CommandFactory {
    public static CommandInterface getCommand(String input) {
        if (input.equals("noop")) {
            return new Nop();
        }
        String[] parts = input.split(" ");
        if (parts[0].equals("addx")) {
            return new Addx(Integer.parseInt(parts[1]));
        }

        return new Nop();
    }
}
