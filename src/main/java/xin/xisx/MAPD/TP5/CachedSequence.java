package xin.xisx.MAPD.TP5;

import xin.xisx.MAPD.TP1.Rational;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CachedSequence extends Sequence {

    private List<Rational> cache;
    private Rational cur;

    public CachedSequence(Rational a, Rational b, Rational u0) {
        super(a, b, u0);
        cache = new ArrayList<>();
        cache.add(u0);
    }

    @Override
    public Rational getUi(int i) {
        int curSize;
        if ((curSize = cache.size()) > i) {
            return cache.get(i);
        }
        cur = cache.get(curSize - 1);
        for (int j = curSize; j <= i; j++) {
            cur = a.multiply(cur).add(b);
            cache.add(cur);
        }
        return cur;
    }

    public Itr getIterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Rational> {

        private Integer cursor = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Rational next() {
            if (cursor < cache.size()) {
                return cache.get(cursor++);
            } else {
                cur = cursor == 0 ? u0 : cache.get(cursor - 1);
                cur = b.add(a.multiply(cur));
                cache.add(cur);
                cursor++;
                return cur;
            }
        }
    }
}
