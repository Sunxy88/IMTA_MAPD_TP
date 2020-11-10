package xin.xisx.MAPD.TP13;

import java.math.BigInteger;
import java.util.function.Function;

public class Fact2 {

    public static Function<Integer, BigInteger> fact = null;

    public Fact2() {
        fact = i ->
                i.compareTo(1) <= 0 ? BigInteger.ONE : new BigInteger(String.valueOf(i)).multiply(fact.apply(i - 1));
    }

}
