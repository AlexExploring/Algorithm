package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {

    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]<o2[0]) return -1;
                else if (o1[0]==o2[0]) return 0;
                else return 1;
            }
        });

        int i = 1,start = intervals[0][0],end = intervals[0][1];
        while (i<intervals.length){
            if (end>=intervals[i][0]){
                if (end<=intervals[i][1]){
                    end = intervals[i][1];
                }
            }else {
                list.add(Arrays.asList(start,end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }
        list.add(Arrays.asList(start,end));

        int row = list.size(),len = list.get(0).size();
        int [][] ans = new int[row][len];
        for (int j = 0; j < row; j++) {
            for (int k = 0; k < len; k++) {
                ans[j][k] = list.get(j).get(k);
            }
        }
        return ans;
    }
}
