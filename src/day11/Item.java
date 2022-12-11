package day11;

import java.math.BigInteger;

public class Item {
    private final BigInteger worryLevel;

    public Item(BigInteger worryLevel) {
        this.worryLevel = worryLevel;
    }

    public BigInteger getWorryLevel() {
        return worryLevel;
    }
}
