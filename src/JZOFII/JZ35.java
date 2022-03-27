package JZOFII;

import java.util.Collections;
import java.util.List;

/**
 * 最小时间差
 */
public class JZ35 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        String fir = timePoints.get(0);
        String sec = timePoints.get(1);
        int fir_h = Integer.valueOf(fir.substring(0, 2));
        int fir_m = Integer.valueOf(fir.substring(3,fir.length()));
        int sec_h = Integer.valueOf(sec.substring(0,2));
        int sec_m = Integer.valueOf(sec.substring(3,sec.length()));

        return sec_h*60+sec_m-fir_h*60-fir_m;
    }
}
