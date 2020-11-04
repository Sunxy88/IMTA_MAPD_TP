package xin.xisx.MAPD.TP11;

import xin.xisx.MAPD.TP1.Rational;
import xin.xisx.MAPD.TP2.WithPGCD;

import java.util.Iterator;
import java.util.function.UnaryOperator;

public class Sequence implements Iterator<Rational> {

    private final Rational u0;
    private Rational u;
    private final UnaryOperator<Rational> compute;

    public Sequence(Rational u0, UnaryOperator<Rational> compute) {
        this.u0 = u0;
        this.compute = compute;
        this.u = u0;
    }


    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Rational next() {
        return compute(u);
    }

    private Rational compute(Rational u) {
        Rational next = compute.apply(u);
        this.u = next;
        return next;
    }

    public Rational index(int i) {
        Rational res, ui;
        ui = u;
        u = u0;
        for (int k = 0; k < i; k++) {
            this.next();
        }
        res = u;
        u = ui;
        return res;
    }

    public static void main(String[] args) {
        // from TP5 : u(i+1) = a*u(i)+b
        Rational a, b, u0;
        a = new WithPGCD(3, 2);
        b = new WithPGCD(1, 2);
        u0 = new WithPGCD(0, 1);
        // test unchanged

        Sequence s = new Sequence(u0, p -> b.sum(a.multiply(p)));
        System.out.println("0 : " + u0);
        for (int i = 1; i < 15; i++) {
            System.out.println(i + " : " + s.next());
        }
        // 19/8 expected
        System.out.println("Direct access");
        System.out.println(s.index(3));
        // 387158345/262144 expected
        System.out.println(s.index(18));
        // 15 ?
        System.out.println(15 + " : " + s.next());
    }
}
