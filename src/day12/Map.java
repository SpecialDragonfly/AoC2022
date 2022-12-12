package day12;

public class Map {
    private int[][] map;
    public Map(int height, int width) {
        this.map = new int[height][width];
    }

    public void addRow(int index, String row) {
        for (int i = 0; i < row.length(); i++) {
            this.map[index][i] = row.charAt(i);
        }
    }

    public void output() {
        for (int[] ints : this.map) {
            for (int anInt : ints) {
                if (anInt == -1) {
                    System.out.print(".");
                } else {
                    System.out.print((char)anInt);
                }
            }
            System.out.println();
        }
    }

}
