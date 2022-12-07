package day7.Commands;

public class CreateFile implements CommandInterface{
    private String file;
    private int size;

    public CreateFile(String file, int size) {

        this.file = file;
        this.size = size;
    }

    public String getFile() {
        return file;
    }

    public int getSize() {
        return size;
    }
}
