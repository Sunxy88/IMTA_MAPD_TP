package xin.xisx.MAPD.TP8and9.impl;

import xin.xisx.MAPD.TP8and9.IList;
import xin.xisx.MAPD.TP8and9.ISortable;
import xin.xisx.MAPD.TP8and9.ISorted;

public class Sortable<T extends Comparable<T>> extends NotEmptyList<T> implements ISortable<T> {

    private IList empty = EmptyList.getInstance();

    public Sortable(T data, IList<T> tail) {
        super(data, tail);
    }

    @Override
    public ISortable<T> getTail() {
        return (ISortable<T>)super.getTail();
    }

    @Override
    public boolean isSorted() {
        if (this == empty) {
            return true;
        }
        try {
            if (getHead().compareTo(getSecond()) >= 0) {
                return getTail().isSorted();
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    @Override
    public ISorted<T> sort() {
        // By applying the recursion thoughts, we can sort this list.
        // The time complexity is O(n^2) and space complexities is O(n).
        // An O(nlogn) algorithm is elaborated in the 148th question in LeetCode
        // by applying the thoughts of divide and conquer.
        // TODO: Optimize this method by divide and conquer.
        return this.getTail().sort().insert(this.getHead());
    }
}
