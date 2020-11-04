package xin.xisx.MAPD.TP11;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import static java.util.Arrays.asList;

public class RainfallTest {

    private void test(List<Integer> rainfalls) {
        System.out.println("====");
        System.out.println(rainfalls);
        System.out.println(Rainfall.rainfall(rainfalls));
    }

    @Test
    public void test() {
        test(Collections.emptyList());
        test(asList(-999));
        test(asList(-1, -2));
        test(asList(1, 2));
        test(asList(1, -3, 2));
        test(asList(1, 2, -3));
        test(asList(1, -999, 2, -3));
    }
}
