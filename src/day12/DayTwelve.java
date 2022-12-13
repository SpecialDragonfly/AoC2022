package day12;

import java.util.Vector;

public class DayTwelve {
    public static void main(String[] args) {
        Vector<String> data = Util.StringFileReader.readFile("./src/day12/Data/input.txt");
        Map map = new Map(data.size(), data.get(0).length());
        for (int i = 0; i < data.size(); i++) {
            map.addRow(i, data.get(i));
        }

        map.run();
        System.out.println("-----------");
        map.runPart2();
        //map.output();
    }
}
