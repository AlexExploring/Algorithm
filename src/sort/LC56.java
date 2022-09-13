package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 */
public class LC56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        //按照每个区间的start从大到小排序,数据范围小，可以直接v1[0]-v2[0],不用担心溢出
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int i = 1,start = intervals[0][0],end = intervals[0][1];
        List<int[]> merged = new ArrayList<>();

        //合并
        while (i < intervals.length){
            // 上一个区间的end大于等于当前区间的start考虑end是否需要改变
            if (end >= intervals[i][0]) {
                // 上一个区间的end小于等于当前区间的end，改变end的值为当前区间的end
                if (end <= intervals[i][1]){
                    end = intervals[i][1];
                }
            }else { // 上一个区间的end小于当前区间的start，当前区间和前面的区间不满足合并要求，将前面的区间合并即可
                merged.add(new int[]{start,end});
                //更新start和end
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }
        merged.add(new int[]{start,end});

        //list转存到数组中
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