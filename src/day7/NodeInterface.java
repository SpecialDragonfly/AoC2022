package day7;

import java.util.TreeMap;

public interface NodeInterface {
    String getName();

    int getSize(TreeMap<String, Integer> sizes);
    int getSize();

    void output(int i);
}
