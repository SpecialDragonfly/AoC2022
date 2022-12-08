package day8;

public class Map {

    private int[][] area;

    public Map(int width, int height) {
        this.area = new int[height][width];
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
        for (int[] ints : this.area) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    public int visible() {
        int count = this.area[0].length * 2 + ((this.area.length - 2) * 2);
        for (int i = 1; i < this.area.length - 1; i++) {
            for (int j = 1; j < this.area[i].length - 1; j++) {
                if (this.pointVisible(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkUp(int i, int j, int pointValue) {
        boolean visible = true;

        // check up from point
        for (int row = 0; row < i; row++) {
            if (this.area[row][j] >= pointValue) {
                visible = false;
                break;
            }
        }

        return visible;
    }

    private boolean checkDown(int i, int j, int pointValue) {
        // check down from point
        boolean visible = true;
        for (int row = i + 1; row < this.area.length; row++) {
            if (this.area[row][j] >= pointValue) {
                visible = false;
                break;
            }
        }

        return visible;
    }

    private boolean checkLeft(int i, int j, int pointValue) {
        // check left from point
        boolean visible = true;
        for (int column = 0; column < j; column++) {
            if (this.area[i][column] >= pointValue) {
                visible = false;
                break;
            }
        }

        return visible;
    }

    private boolean checkRight(int i, int j, int pointValue) {
        // check right from point
        boolean visible = true;
        for (int column = j + 1; column < this.area[i].length; column++) {
            if (this.area[i][column] >= pointValue) {
                visible = false;
                break;
            }
        }

        return visible;
    }

    private boolean pointVisible(int i, int j) {
        int pointValue = this.area[i][j];
        boolean visible = this.checkUp(i, j, pointValue);
        visible = visible || this.checkDown(i, j, pointValue);
        visible = visible || this.checkLeft(i, j, pointValue);
        visible = visible || this.checkRight(i, j, pointValue);

        return visible;
    }
}
