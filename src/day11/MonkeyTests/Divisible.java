package day11.MonkeyTests;

import java.math.BigInteger;

public class Divisible {
    private final BigInteger divisor;

    public Divisible(BigInteger divisor) {
        this.divisor = divisor;
    }

    public boolean test(BigInteger newWorryLevel) {
        return newWorryLevel.gcd(this.divisor).equals(this.divisor);
        //return newWorryLevel.remainder(this.divisor).equals(BigInteger.ZERO);
    }
}
