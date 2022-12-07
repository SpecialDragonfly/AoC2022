package day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    public static HashMap<Integer, String> run(String token) {
        HashMap<Integer, String> values = new HashMap<Integer, String>();
        int port = 1;
        for (int i = 0; i < token.length(); i++) {
            if (token.charAt(i) == '[') {
                i++;
                values.put(port, String.valueOf(token.charAt(i)));
                port++;
            }
            if (token.charAt(i) == ' ') {
                i++;
                if (token.charAt(i) == ' ') {
                    // blank space
                    port++;
                    i += 2;
                } else if (token.charAt(i) == '[') {
                    i--;
                }
            }
        }
        return values;
    }

    public static Instruction parseMovement(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        ArrayList<Integer> list = new ArrayList<Integer>();
        Matcher m = pattern.matcher(line);
        while (m.find()) {
            list.add(Integer.valueOf(m.group()));
        }
        return new Instruction(list.get(0), list.get(1), list.get(2));
    }
}
