package day11.Operations;

import java.math.BigInteger;

public class Square implements OperationInterface {
    @Override
    public BigInteger actUpon(BigInteger worryLevel) {
        return worryLevel.multiply(worryLevel);
    }
}
