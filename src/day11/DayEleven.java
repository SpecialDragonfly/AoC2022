package day11;

import day11.MonkeyTests.Divisible;
import day11.Operations.Add;
import day11.Operations.Multiply;
import day11.Operations.Square;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Vector;

public class DayEleven {
    public static void main(String[] args) {
        Vector<String> data = Util.StringFileReader.readFile("./src/day11/Data/input.txt");
        ArrayList<Monkey> monkeys = new ArrayList<>();
        Monkey monkey = null;
        for (String line : data) {
            line = line.trim();
            if (line.startsWith("Monkey")) {
                // New Monkey!
                monkey = new Monkey(2*7*11*19*3*5*17*13);
            }
            if (line.trim().equals("")) {
                monkeys.add(monkey);
            }
            if (line.startsWith("Starting") && monkey != null) {
                // List of items.
                String itemsString = line.substring("Starting items :".length());
                String[] items = itemsString.split(",");
                for (String item : items) {
                    monkey.addItem(new Item(BigInteger.valueOf(Integer.parseInt(item.trim()))));
                }
            }
            if (line.startsWith("Operation") && monkey != null) {
                String operation = line.substring("Operation: new = old ".length());
                String[] parts = operation.split(" ");
                if (parts[0].equals("+")) {
                    monkey.setOperation(new Add(BigInteger.valueOf(Integer.parseInt(parts[1].trim()))));
                } else if (parts[0].equals("*")) {
                    if (parts[1].equals("old")) {
                        monkey.setOperation(new Square());
                    } else {
                        monkey.setOperation(new Multiply(BigInteger.valueOf(Integer.parseInt(parts[1].trim()))));
                    }
                }
            }
            if (line.startsWith("Test: divisible by ") && monkey != null) {
                monkey.setTest(
                    new Divisible(
                        BigInteger.valueOf(
                            Integer.parseInt(
                                line.substring("Test: divisible by ".length()).trim()
                            )
                        )
                    )
                );
            }
            if (line.startsWith("If true: ") && monkey != null) {
                monkey.setIfTrue(Integer.parseInt(line.substring("If true: throw to monkey ".length()).trim()));
            }
            if (line.startsWith("If false: ") && monkey != null) {
                monkey.setIfFalse(Integer.parseInt(line.substring("If false: throw to monkey ".length()).trim()));
            }
        }
        monkeys.add(monkey);

        int maxRounds = 10000;

        System.out.println(System.currentTimeMillis());
        long time = System.currentTimeMillis();
        for (int rounds = 0; rounds < maxRounds; rounds++) {
            for (int i = 0; i < monkeys.size(); i++) {
                monkeys.get(i).inspectItem(monkeys);
            }
            if (rounds % 1000 == 0) {
                System.out.println("Round " + rounds + " @ " + (System.currentTimeMillis() - time));
                time = System.currentTimeMillis();
                for (int i = 0; i < monkeys.size(); i++) {
                    System.out.println("Monkey " + i + " has inspected " + monkeys.get(i).getInspectionCount() + " items.");
                }
                System.out.println("----------------");
            }
        }
        for (int i = 0; i < monkeys.size(); i++) {
            System.out.println("Monkey " + i + " has inspected " + monkeys.get(i).getInspectionCount() + " items.");
        }

    }
}
