package xin.xisx.MAPD.TP8and9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xin.xisx.MAPD.TP8and9.impl.EmptyList;
import xin.xisx.MAPD.TP8and9.impl.NotEmptyList;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Exercise1Test {

    private IList<Integer> head;
    private IList empty;

    @Before
    public void setUp() {
        empty = EmptyList.getInstance();
        head = generateList(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    public void generateListTest() {
        IList<Integer> ptr = head;
        while (ptr != empty) {
            System.out.print(ptr.getHead() + " ");
            ptr = ptr.getTail();
        }
    }

    @Test
    public void notEmptyListIsEmptyTest() {
        Assert.assertFalse(head.isEmpty());
    }

    @Test
    public void notEmptyListSizeTest() {
        Assert.assertEquals(Integer.valueOf(5), Integer.valueOf(head.size()));
    }

    @Test
    public void notEmptyListGetterTest() {
        Assert.assertEquals(Integer.valueOf(5), head.getHead());
        Assert.assertEquals(Integer.valueOf(4), head.getSecond());
    }

    @Test
    public void emptyListSingletonTest() {
        IList empty2 = EmptyList.getInstance();
        Assert.assertEquals(empty2, empty);
    }

    @Test
    public void emptyListIsEmptyTest() {
        Assert.assertTrue(empty.isEmpty());
    }

    @Test
    public void emptyListSizeTest() {
        Assert.assertEquals(Integer.valueOf(0), Integer.valueOf(empty.size()));
    }

    @Test
    public void emptyListGetTest() {
        try {
            empty.getHead();
            Assert.fail("Should throw an exception");
        } catch (NoSuchElementException e) {}

        try {
            empty.getSecond();
            Assert.fail("Should throw an exception");
        } catch (NoSuchElementException e) {}

        Assert.assertEquals(empty.getTail(), empty);
    }

    private <T> IList<T> generateList(List<T> originalData) {
        ListIterator<T> listIterator = originalData.listIterator();
        IList<T> head = empty;

        while (listIterator.hasNext()) {
            head = new NotEmptyList<>(listIterator.next(), head);
        }

        return head;
    }
}
