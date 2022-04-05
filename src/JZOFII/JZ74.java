package JZOFII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 */
public class JZ74 {

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                merged.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            if (end >= intervals[i][1]) {
                continue;
            }else if (end >= intervals[i][0]) {
                end = intervals[i][1];
            }
        }
        merged.add(new int[]{start,end});
        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] merge1(int[][] intervals) {

        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        List<int[]> merged = new ArrayList<int[]>();
        for (int[] interval: intervals) {
            // 如果列表为空,或者当前区间与上一区间不重合,直接添加
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // 否则的话,我们就可以与上一区间进行合并
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[0][]);
    }
}
