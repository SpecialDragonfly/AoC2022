package day7.Commands;

public class CreateDirectory implements CommandInterface{
    private String dir;

    public CreateDirectory(String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }
}
