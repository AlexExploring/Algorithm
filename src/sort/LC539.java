package sort;

import java.util.Collections;
import java.util.List;

/**
 * 最小时间差
 */
public class LC539 {

    /**
     * 将 timePoints 排序后，最小时间差必然出现在timePoints 的两个相邻时间，
     * 或者 timePoints 的两个首尾时间中。
     */
    public int findMinDifference(List<String> timePoints) {
        // 由于时间精确到分钟，如果timePoints的长度超过1440，则必然有重复的时间，差值为0
        if (timePoints.size() > 1440) {
            return 0;
        }

        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < timePoints.size(); ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
            preMinutes = minutes;
        }
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
        return ans;
    }

    /**
     * 获取 00:00 格式时间的分钟数。
     */
    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}
