package day7;

import java.util.ArrayList;
import java.util.TreeMap;

public class Directory implements NodeInterface{
    private final Directory parent;
    private String directoryName;

    private ArrayList<NodeInterface> children;

    public Directory(String nodeName, Directory parent) {
        this.directoryName = nodeName;
        this.parent = parent;
        this.children = new ArrayList<NodeInterface>();
    }

    public boolean hasChild(String dir) {
        for (NodeInterface child : this.children) {
            if (child.getName().equals(dir)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return this.directoryName;
    }

    public void addChild(String node) {
        this.children.add(new Directory(node, this));
    }

    public void addFile(String name, int size) {
        this.children.add(new File(name, size));
    }

    public Directory getParent() {
        return this.parent;
    }

    public Directory changeDir(String dir) {
        for (NodeInterface child : this.children) {
            if (!(child instanceof File) && child.getName().equals(dir)) {
                return (Directory)child;
            }
        }
        return null;
    }

    public int getSize(TreeMap<String, Integer> sizes) {
        int size = 0;
        for (NodeInterface child : this.children) {
            size += child.getSize(sizes);
        }
        if (sizes.containsKey(this.directoryName)) {
            sizes.put(this.directoryName + this.hashCode(), size);
        } else {
            sizes.put(this.directoryName, size);
        }
        return size;
    }

    public int getSize() {
        int size = 0;
        for (NodeInterface child : this.children) {
            size += child.getSize();
        }
        return size;
    }

    public void output(int initialSpaces) {
        System.out.println(("\t".repeat(initialSpaces)) + this.getName() + " : " + this.getSize());
        for (NodeInterface child : this.children) {
            child.output(initialSpaces + 1);
        }
    }
}
