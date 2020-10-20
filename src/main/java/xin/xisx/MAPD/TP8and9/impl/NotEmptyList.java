package xin.xisx.MAPD.TP8and9.impl;

import xin.xisx.MAPD.TP8and9.IList;

/**
 * Exercise 1
 * @param <T>
 */
public class NotEmptyList<T> implements IList<T> {

    private T head;
    private IList<T> tail;

    public NotEmptyList(T data, IList<T> tail) {
        this.head = data;
        this.tail = tail;
    }

    @Override
    public int size() {
        return tail.size() + 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T getHead() {
        return head;
    }

    @Override
    public IList<T> getTail() {
        return tail;
    }
}
