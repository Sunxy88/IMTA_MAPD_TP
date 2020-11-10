package xin.xisx.MAPD.TP13;

import java.math.BigInteger;

public class Fact1 {

    public static BigInteger fact(int n) {
        return new Fact() {

            @Override
            public BigInteger fact(int n) {
                return n <= 1 ? BigInteger.ONE : BigInteger.valueOf(n).multiply(fact(n - 1));
            }
        }.fact(n);
    }

}