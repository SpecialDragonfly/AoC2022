package day8;

public class ScenicMap {

    private final int[][] area;

    private final int[][] scenicMap;

    public ScenicMap(int width, int height) {
        this.area = new int[height][width];
        this.scenicMap = new int[height][width];
    }

    public void parse(int row, String line) {
        String[] parts = line.split("");
        int i = 0;
        for (String part : parts) {
            this.area[row][i] = Integer.parseInt(part);
            i++;
        }
    }

    public void output() {
        for (int[] value : this.area) {
            for (int i : value) {
                System.out.print(i);
            }
            System.out.println();
        }
        System.out.println();

        for (int[] ints : this.scenicMap) {
            for (int anInt : ints) {
                System.out.print(anInt + " | ");
            }
            System.out.println();
        }
    }

    public void calculateScenicValues() {
        for (int i = 1; i < this.area.length - 1; i++) {
            for (int j = 1; j < this.area[i].length - 1; j++) {
                this.scenicMap[i][j] = this.scenicValue(i, j);
            }
        }
    }

    private int checkUp(int i, int j, int pointValue) {
        int visible = 0;

        // check up from point
        for (int row = i - 1; row >= 0; row--) {
            visible++;
            if (this.area[row][j] >= pointValue) {
                break;
            }
        }

        return visible;
    }

    private int checkDown(int i, int j, int pointValue) {
        // check down from point
        int visible = 0;
        for (int row = i + 1; row < this.area.length; row++) {
            visible++;
            if (this.area[row][j] >= pointValue) {
                break;
            }
        }

        return visible;
    }

    private int checkLeft(int i, int j, int pointValue) {
        // check left from point
        int visible = 0;
        for (int column = j - 1; column >= 0; column--) {
            visible++;
            if (this.area[i][column] >= pointValue) {
                break;
            }
        }

        return visible;
    }

    private int checkRight(int i, int j, int pointValue) {
        // check right from point
        int visible = 0;
        for (int column = j + 1; column < this.area[i].length; column++) {
            visible++;
            if (this.area[i][column] >= pointValue) {
                break;
            }
        }

        return visible;
    }

    private int scenicValue(int i, int j) {
        int pointValue = this.area[i][j];
        int up = this.checkUp(i, j, pointValue);
        int down = this.checkDown(i, j, pointValue);
        int left = this.checkLeft(i, j, pointValue);
        int right = this.checkRight(i, j, pointValue);
        return up * down * left * right;
    }

    public int maxScenicValue() {
        int max = 0;
        for (int[] ints : this.scenicMap) {
            for (int anInt : ints) {
                if (anInt > max) {
                    max = anInt;
                }
            }
        }

        return max;
    }
}
