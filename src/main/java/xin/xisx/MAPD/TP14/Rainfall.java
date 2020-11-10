package xin.xisx.MAPD.TP14;

import java.util.List;

public class Rainfall {

    public static double rainfall(List<Integer> list) {
        return list.stream().takeWhile(ele -> ele != -999).
                filter(e -> e > 0).
                mapToDouble(Integer::doubleValue).
                average().getAsDouble();
    }

}
