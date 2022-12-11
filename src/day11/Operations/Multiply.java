package day11.Operations;

import java.math.BigInteger;

public class Multiply implements OperationInterface {
    private final BigInteger value;

    public Multiply(BigInteger value) {
        this.value = value;
    }

    @Override
    public BigInteger actUpon(BigInteger worryLevel) {
        return worryLevel.multiply(this.value);
    }
}
