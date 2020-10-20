package xin.xisx.MAPD.TP8and9;

/**
 * Exercise 2
 * @author Xi Song
 * @param <T>
 */
public interface ISortable<T extends Comparable<T>> extends IList<T> {
    boolean isSorted();
    ISorted<T> sort();
}
