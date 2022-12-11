package day11;

import day11.MonkeyTests.Divisible;
import day11.Operations.OperationInterface;

import java.math.BigInteger;
import java.util.ArrayList;

public class Monkey {
    private final ArrayList<Item> items;
    private OperationInterface operation;
    private Divisible test;
    private int trueMonkey;
    private int falseMonkey;

    private int inspectionCount = 0;
    private final long leastCommonDivisor;

    public Monkey(long leastCommonDivisor) {
        this.leastCommonDivisor = leastCommonDivisor;
        this.items = new ArrayList<>();
    }
    public void addItem(Item item) {
        this.items.add(item);
    }

    public void setOperation(OperationInterface operation) {
        this.operation = operation;
    }

    public void setTest(Divisible divisibleTest) {
        this.test = divisibleTest;
    }

    public void setIfTrue(int monkeyIndex) {
        this.trueMonkey = monkeyIndex;
    }

    public void setIfFalse(int monkeyIndex) {
        this.falseMonkey = monkeyIndex;
    }

    public void inspectItem(ArrayList<Monkey> monkeys) {
        while (this.items.size() > 0) {
            Item inspected = this.items.remove(0);
            this.inspectionCount++;
            BigInteger newWorryLevel = this.operation.actUpon(inspected.getWorryLevel());
            newWorryLevel = newWorryLevel.mod(BigInteger.valueOf(this.leastCommonDivisor));

            if (this.test.test(newWorryLevel)) {
                monkeys.get(this.trueMonkey).addItem(new Item(newWorryLevel));
            } else {
                monkeys.get(this.falseMonkey).addItem(new Item(newWorryLevel));
            }
        }
    }

    public int getInspectionCount() {
        return inspectionCount;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        for (Item item : this.items) {
            b.append(item.getWorryLevel());
            b.append(",");
        }
        return b.toString();
    }
}
