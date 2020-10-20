package xin.xisx.MAPD.TP8and9;

/**
 * Exercise 1
 * @param <T>
 * @author Xi Song
 */
public interface IList<T> {
    int size();

    boolean isEmpty();

    T getHead();

    default T getSecond() {
        return getTail().getHead();
    }

    IList<T> getTail();
}
