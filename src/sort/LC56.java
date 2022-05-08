package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 */
public class LC56 {

    public int[][] merge(int[][] intervals) {

        List<List<Integer>> list = new ArrayList<>();
        //按照每个区间的start从大到小排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]<o2[0]) return -1;
                else if (o1[0]==o2[0]) return 0;
                else return 1;
            }
        });

        //合并
        int i = 1,start = intervals[0][0],end = intervals[0][1];
        while (i<intervals.length){
            // 上一个区间的end小于等于当前区间的start考虑end是否需要改变
            if (end >= intervals[i][0]){
                // 上一个区间的end小于等于当前区间的end，改变end的值为当前区间的end
                if (end <= intervals[i][1]){
                    end = intervals[i][1];
                }
                // 当前区间和前面的区间不满足合并要求
            }else {
                list.add(Arrays.asList(start,end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }
        list.add(Arrays.asList(start,end));

        //list转存到数组中
        int row = list.size(),len = list.get(0).size();
        int [][] ans = new int[row][len];
        for (int j = 0; j < row; j++) {
            for (int k = 0; k < len; k++) {
                ans[j][k] = list.get(j).get(k);
            }
        }

        return ans;
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
