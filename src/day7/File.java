package day7;

import java.util.TreeMap;

public class File implements NodeInterface{
    private String name;
    private int size;

    public File(String name, int size) {

        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize(TreeMap<String, Integer> sizes) {
        return size;
    }
    public int getSize() {
        return size;
    }

    @Override
    public void output(int initialSpaced) {
        System.out.println("\t".repeat(initialSpaced) + this.getName() + "(" + this.getSize() + ")");
    }
}
