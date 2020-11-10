package xin.xisx.MAPD.TP13;

import org.junit.Test;

public class Test13 {

    private int n = 10000;

    @Test
    public void fact1Test() {
        System.out.println(Fact1.fact(n));
        System.out.println(Fact1.fact(n).toString().length());
    }

    @Test
    public void fact2Test() {
        Fact2 fact2;
        fact2 = new Fact2();
        try {
            System.out.println(Fact2.fact.apply(n));
            System.out.println(Fact2.fact.apply(n).toString().length());
        } catch (StackOverflowError error) {
            error.printStackTrace();
        }

    }

    @Test
    public void fact3Test() {
        System.out.println(Fact3.fact(n));
        System.out.println(Fact3.fact(n).toString().length());
    }
}
