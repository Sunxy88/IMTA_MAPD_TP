package xin.xisx.MAPD.TP13;

import java.math.BigInteger;

public class Fact3 {

    public static BigInteger fact(int n) {
        try {
            new Fact2();
            return Fact2.fact.apply(n);
        } catch (StackOverflowError error) {
            return Fact1.fact(n);
        }
    }
}
