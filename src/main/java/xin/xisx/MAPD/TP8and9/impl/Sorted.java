package xin.xisx.MAPD.TP8and9.impl;

import xin.xisx.MAPD.TP8and9.IList;
import xin.xisx.MAPD.TP8and9.ISorted;

public class Sorted<T extends Comparable<T>> extends Sortable<T> implements ISorted<T> {

    public Sorted(T data, IList<T> tail) {
        super(data, tail);
        adjustHead();
    }

    @Override
    public boolean isSorted() {
        return true;
    }

    @Override
    public ISorted<T> sort() {
        return this;
    }

    @Override
    public ISorted<T> insert(T t) {
        T first = getHead();
        int res = t.compareTo(first);
        if (res == 0) {
            return this;
        } else if (res < 0) {
            // t > head, so we directly insert it into the first position.
            return new Sorted<>(t, this);
        } else {
            // res > 0 means that t is larger the first element, so it should be inserted at least the next position.
            // Use a constructor to insert and also guarantee the order.
            return new Sorted<>(first, new Sorted<>(t, getTail()));
        }
    }

    /**
     * To maintain the order of this list.
     */
    private void adjustHead() {
        T first = getHead();
        try {
            T second = getSecond();
            int res = first.compareTo(second);
            if (res > 0) {
                setHead(second);
                ((NotEmptyList)getTail()).setHead(first);
                ((Sorted)(getTail())).adjustHead();
            }
        } catch (Exception e) {}
    }
}
