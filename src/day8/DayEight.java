package day8;

import day7.Directory;

import java.util.Vector;

public class DayEight {
    public static void main(String[] args) {
        Vector<String> data = Util.StringFileReader.readFile("./src/day8/Data/input.txt");
        ScenicMap map = new ScenicMap(data.size(), data.get(0).length());
        int i = 0;
        for (String line : data) {
            map.parse(i, line);
            i++;
        }
        map.calculateScenicValues();
        System.out.println("Maximum scenic value is " + map.maxScenicValue());
    }
}
