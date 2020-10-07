package xin.xisx.MAPD.TP5;

import org.junit.Before;
import org.junit.Test;
import xin.xisx.MAPD.TP1.Rational;
import xin.xisx.MAPD.TP2.WithPGCD;

import java.util.Iterator;

public class TP5Test {

    private Rational a, b, u0;

    @Before
    public void setUp() {
        a = new WithPGCD(1, 2);
        b = new WithPGCD(0, 1);
        u0 = new WithPGCD(1, 1);
    }

    @Test
    public void SequenceTest() {
        Sequence itr = new Sequence(a, b, u0);
        for (int i = 0; i < 10; i++) {
            System.out.println(itr.next());
        }
    }

    @Test
    public void CachedSequenceTest() {
        CachedSequence cachedSequence = new CachedSequence(a, b, u0);
        Iterator itr = cachedSequence.getIterator();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            System.out.println(itr.next());
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Time passed: " + (t2 - t1));

        itr = cachedSequence.getIterator();
        t1 = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            System.out.println(itr.next());
        }
        t2 = System.currentTimeMillis();
        System.out.println("Time passed: " + (t2 - t1));
    }

    @Test
    public void SerieTest() {
        Serie s = new Serie(a, b, u0);
        for (int i = 0; i < 10; i++) {
            System.out.println(s.getSi(i));
//            s.getSi(i);
        }
    }
}
