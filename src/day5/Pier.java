package day5;

import java.util.ArrayList;
import java.util.Stack;

public class Pier {
    private ArrayList<Stack<String>> ports;
    public Pier(int stacks) {
        this.ports = new ArrayList<>();
        for (int i = 0; i < stacks; i++) {
            ports.add(new Stack<>());
        }
    }

    public void addValueToPort(int port, String value) {
        this.ports.get(port - 1).add(value);
    }

    public void perform(Instruction instruction) {
        int destination = instruction.getEnd();
        int source = instruction.getStart();
        int number = instruction.getQuantity();
        for (int i = 0; i < number; i++) {
            this.move(source, destination);
        }
    }

    private void move(int from, int to) {
        String pop = this.ports.get(from - 1).pop();
        this.ports.get(to - 1).add(pop);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Stack<String> port : this.ports) {
            builder.append(port.peek());
        }
        return builder.toString();
    }
}
