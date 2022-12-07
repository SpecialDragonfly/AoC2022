package day5;

public class Instruction {
    private final int quantity;
    private final int start;
    private final int end;

    public Instruction(int quantity, int start, int end) {
        this.quantity = quantity;
        this.start = start;
        this.end = end;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
