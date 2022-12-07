package day5;

import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

public class DayFive {
    public static void main(String[] args) {
        Vector<String> data = Util.StringFileReader.readFile("./src/day5/Data/input.txt");

        AdvancedPier pier = setupBuckets(data);

        for (String line : data) {
            if (line.startsWith("move")) {
                Instruction instruction = Tokenizer.parseMovement(line);
                pier.perform(instruction);
            }
        }
        System.out.println(pier.toString());
    }

    private static AdvancedPier setupBuckets(Vector<String> data) {
        Stack<String> buckets = new Stack<>();
        int i = 0;
        while (!data.get(i).trim().equals("")) {
            buckets.add(data.get(i));
            System.out.println(data.get(i));
            i++;
        }

        // We now have a stack defining our buckets, but how many do we have?
        String bucketCount = buckets.pop();
        String[] parts = bucketCount.split("   ");
        int lastNumber = Integer.parseInt(parts[parts.length - 1].trim());
        System.out.println("Found " + lastNumber + " buckets");

        // Create X stacks.
        //Pier pier = new Pier(lastNumber);
        AdvancedPier pier = new AdvancedPier(lastNumber);

        while (buckets.size() > 0) {
            String line = buckets.pop();
            HashMap<Integer, String> tokens = Tokenizer.run(line);
            tokens.forEach((port, value) -> {
                pier.addValueToPort(port, value);
            });
        }

        return pier;
    }
}
