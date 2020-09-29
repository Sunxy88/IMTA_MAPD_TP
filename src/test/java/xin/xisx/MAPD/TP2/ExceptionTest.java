package xin.xisx.MAPD.TP2;

import org.junit.Test;
import xin.xisx.MAPD.TP1.Rational;

public class ExceptionTest {

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
}
