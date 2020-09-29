package xin.xisx.MAPD.TP1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class TP1TestClass {

    private Random random;

    @Before
    public void setup() {
        random = new Random(System.currentTimeMillis());
    }

    @Test
    public void toStringTest() {
        for (int i = 0; i < 10; i++) {
            int flag = 1;
            if (i % 3 == 0)
                flag = -1;
            System.out.println(new Rational(flag * random.nextInt(100), random.nextInt(150)));
        }

    }

    @Test
    public void equalsTest() {
        Rational r1 = new Rational(2, 3);
        Rational r2 = new Rational(2, 3);
        Rational r3 = new Rational(3, 6);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println("r1.equals(r2) : " + r1.equals(r2));
        System.out.println("r1.equals(r3) : " + r1.equals(r3));

    }

    @Test
    public void addTest() {
        for (int i = 0; i < 10; i++) {
            int flag = 1;
            if (i % 3 == 0)
                flag = -1;
            Rational r1 = new Rational(flag * random.nextInt(10), random.nextInt(15));
            Rational r2 = new Rational(flag * random.nextInt(10), random.nextInt(15));
            System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        }
    }

    @Test
    public void multiplyTest() {
        for (int i = 0; i < 10; i++) {
            int flag = 1;
            if (i % 3 == 0)
                flag = -1;
            Rational r1 = new Rational(flag * random.nextInt(10), random.nextInt(15));
            Rational r2 = new Rational(flag * random.nextInt(10), random.nextInt(15));
            System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        }
    }
}
