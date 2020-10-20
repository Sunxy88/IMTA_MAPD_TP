package xin.xisx.MAPD.TP8and9.impl;

import xin.xisx.MAPD.TP8and9.IList;

import java.util.NoSuchElementException;

/**
 * Exercise 1
 * Use singleton pattern, because I think it could save space.
 * @param <T>
 */
public class EmptyList<T> implements IList<T> {

    private static volatile IList singleton;

    private EmptyList() {}

    public static IList getInstance() {
        if (singleton == null) {
            synchronized (EmptyList.class) {
                if (singleton == null) {
                    singleton = new EmptyList();
                }
            }
        }
        return singleton;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T getHead() {
        throw new NoSuchElementException();
    }

    @Override
    public IList<T> getTail() {
        return getInstance();
    }
}
