package day7;

import day7.Commands.ChangeDirectory;
import day7.Commands.CommandInterface;
import day7.Commands.CreateDirectory;
import day7.Commands.CreateFile;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class DaySeven {
    public static void main(String[] args) {
        Vector<String> data = Util.StringFileReader.readFile("./src/day7/Data/input.txt");
        Directory node = new Directory("root", null);

        // Build it!
        for (String line : data) {
            CommandInterface command = Tokenizer.parse(line);
            if (command instanceof ChangeDirectory) {
                if (((ChangeDirectory) command).getDir().equals("..")) {
                    node = node.getParent();
                } else {
                    // Does the directory exist?
                    if (!node.hasChild(((ChangeDirectory) command).getDir())) {
                        node.addChild(((ChangeDirectory) command).getDir());
                    }
                    node = node.changeDir(((ChangeDirectory) command).getDir());
                }
            } else if (command instanceof CreateDirectory) {
                node.addChild(((CreateDirectory) command).getDir());
            } else if (command instanceof CreateFile) {
                node.addFile(((CreateFile) command).getFile(), ((CreateFile) command).getSize());
            }
        }
        // Back to root.
        while (node.getParent() != null) {
            node = node.getParent();
        }
        // Print out the tree
        //node.output(0);

        TreeMap<String, Integer> sizes = new TreeMap<>();
        node.getSize(sizes);
//        int smallDirectorySizes = 0;
//        for (Map.Entry<String, Integer> e : sizes.entrySet()) {
//            if (e.getValue() <= 100000) {
//                System.out.println(e.getKey() + " has a size of " + e.getValue());
//                smallDirectorySizes += e.getValue();
//            }
//        }
//        System.out.println("Total: " + smallDirectorySizes);

        int currentSize = sizes.get("/");
        System.out.println("Current size is " + currentSize);
        int remainingSpace = 70000000 - currentSize;
        System.out.println("Remaining space is " + remainingSpace);
        int neededSpace = 30000000;
        int needToDelete = neededSpace - remainingSpace;
        System.out.println("Need to delete " + needToDelete);
        for (Map.Entry<String, Integer> e : sizes.entrySet()) {
            if (e.getValue() >= needToDelete) {
                System.out.println("Could delete " + e.getKey() + " to free up " + e.getValue() + " at an over of " + (e.getValue() - needToDelete));
            }
        }
    }
}
