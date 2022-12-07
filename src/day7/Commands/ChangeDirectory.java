package day7.Commands;

public class ChangeDirectory implements CommandInterface{
    private String dir;

    public ChangeDirectory(String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }
}
