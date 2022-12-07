package day5;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

public class AdvancedPier {
    private ArrayList<Stack<String>> ports;
    public AdvancedPier(int stacks) {
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
        Stack<String> queue = new Stack<>();
        for (int i = 0; i < number; i++) {
            queue.add(this.ports.get(source - 1).pop());
        }
        this.move(queue, destination);
    }
    private void move(Stack<String> queue, int to) {
        while (queue.size() > 0) {
            this.ports.get(to - 1).add(queue.pop());
        }
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Stack<String> port : this.ports) {
            builder.append(port.peek());
        }
        return builder.toString();
    }
}
