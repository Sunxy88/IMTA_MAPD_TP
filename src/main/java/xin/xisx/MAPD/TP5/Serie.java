package xin.xisx.MAPD.TP5;

import xin.xisx.MAPD.TP1.Rational;

public class Serie {
    private Sequence sequence;
    private Rational s;

    public Serie(Rational a, Rational b, Rational u0) {
        this.sequence = new CachedSequence(a, b, u0);
        this.s = u0;
    }

    public Rational getSi(int i) {
        s = sequence.getUi(0);
        for (int j = 0; j <= i; j++) {
            s = s.add(sequence.getUi(j));
        }
        return s;
    }
}
