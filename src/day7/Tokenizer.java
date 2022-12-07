package day7;

import day7.Commands.*;

public class Tokenizer {
    public static CommandInterface parse(String line) {
        // $ ls
        // dir X
        // <size> filename
        // $ cd X
        // $ cd ..
        if (line.startsWith("$")) {
            // command
            String[] parts = line.split(" ");
            if (parts[1].equals("ls")) {
                // directory listing, nobody cares
                return new Nop(line);
            } else {
                // cd X
                return new ChangeDirectory(parts[2]);
            }
        } else if (line.startsWith("dir")) {
            // directory
            String[] parts = line.split(" ");
            return new CreateDirectory(parts[1]);
        } else {
            // file
            String[] parts = line.split(" ");
            return new CreateFile(parts[1], Integer.parseInt(parts[0]));
        }
    }
}
