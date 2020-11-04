package xin.xisx.MAPD.TP11;

import java.util.List;

public class Rainfall {
    public static double rainfall(List<Integer> rainfalls) {
        if (rainfalls.isEmpty()) {
            return 0;
        }
        int sum = 0;
        int n = 0;
        for (int rainfall : rainfalls) {
            if (rainfall == -999) {
                break;
            }
            if (rainfall > 0) {
                n++;
                sum += rainfall;
            }
        }
        if (n != 0) {
            return (double) sum / n;
        } else {
            return 0;
        }
    }
}
