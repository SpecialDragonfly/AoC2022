package day11.Operations;

import java.math.BigInteger;

public class Add implements OperationInterface {
    private final BigInteger value;

    public Add(BigInteger value) {
        this.value = value;
    }

    @Override
    public BigInteger actUpon(BigInteger worryLevel) {
        return worryLevel.add(this.value);
    }
}
