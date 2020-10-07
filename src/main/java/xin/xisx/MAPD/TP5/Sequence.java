package xin.xisx.MAPD.TP5;

import xin.xisx.MAPD.TP1.Rational;

import java.util.Iterator;

public class Sequence implements Iterator<Rational> {

    protected Rational a;
    protected Rational b;
    protected Rational u0;
    private Rational cur;

    public Sequence(Rational a, Rational b, Rational u0) {
        this.a = a;
        this.b = b;
        this.u0 = u0;
        this.cur = u0;
    }

    public Rational getUi(int i) {
        if (i <= 0) {
            return u0;
        }
        cur = u0;
        for (int j = 0; j < i; j++) {
            cur = b.add(cur.multiply(a));
        }
        return cur;
    }

    /**
     * Always have the i + 1th element
     */
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Rational next() {
        cur = b.add(cur.multiply(a));
        return cur;
    }
}
