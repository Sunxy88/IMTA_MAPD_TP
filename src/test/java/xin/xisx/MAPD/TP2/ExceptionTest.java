package xin.xisx.MAPD.TP2;

import org.junit.Before;
import org.junit.Test;
import xin.xisx.MAPD.TP1.Rational;

import java.util.Random;

public class ExceptionTest {

    private Random random;

    @Before
    public void setup() {
        random = new Random(System.currentTimeMillis());
    }

    @Test
    public void UndefinedExceptionTest1() {
        try {
            Rational r = new Rational();
        } catch (UndefinedRationalException e) {
            e.printStackTrace();
            System.out.println("Done");
        }
    }

    @Test
    public void UndefinedExceptionTest2() {
        try {
            Rational r = new Rational(1, 0);
        } catch (UndefinedRationalException e) {
            e.printStackTrace();
            System.out.println("Done");
        }
    }

    @Test
    public void addTest() {
        for (int i = 0; i < 10; i++) {
            int flag = 1;
            if (i % 3 == 0)
                flag = -1;
            Rational r1 = new WithPGCD(flag * random.nextInt(10), random.nextInt(15) + 1);
            Rational r2 = new WithPGCD(flag * random.nextInt(10), random.nextInt(15) + 1);
            System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        }
    }

    @Test
    public void multiplyTest() {
        for (int i = 0; i < 10; i++) {
            int flag = 1;
            if (i % 3 == 0)
                flag = -1;
            Rational r1 = new WithPGCD(flag * random.nextInt(10), random.nextInt(15) + 1);
            Rational r2 = new WithPGCD(flag * random.nextInt(10), random.nextInt(15) + 1);
            System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        }
    }
}
