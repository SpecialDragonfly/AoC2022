package day7.Commands;

public class Nop implements CommandInterface {
    private String nop;

    public Nop(String nop) {

        this.nop = nop;
    }

    public String getNop() {
        return nop;
    }
}
