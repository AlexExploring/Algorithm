package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * �ϲ�����
 */
public class LC56 {

    public int[][] merge(int[][] intervals) {

        List<List<Integer>> list = new ArrayList<>();
        //����ÿ�������start�Ӵ�С����
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]<o2[0]) return -1;
                else if (o1[0]==o2[0]) return 0;
                else return 1;
            }
        });

        //�ϲ�
        int i = 1,start = intervals[0][0],end = intervals[0][1];
        while (i<intervals.length){
            // ��һ�������endС�ڵ��ڵ�ǰ�����start����end�Ƿ���Ҫ�ı�
            if (end >= intervals[i][0]){
                // ��һ�������endС�ڵ��ڵ�ǰ�����end���ı�end��ֵΪ��ǰ�����end
                if (end <= intervals[i][1]){
                    end = intervals[i][1];
                }
                // ��ǰ�����ǰ������䲻����ϲ�Ҫ��
            }else {
                list.add(Arrays.asList(start,end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }
        list.add(Arrays.asList(start,end));

        //listת�浽������
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
            // ����б�Ϊ��,���ߵ�ǰ��������һ���䲻�غ�,ֱ�����
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // ����Ļ�,���ǾͿ�������һ������кϲ�
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[0][]);
    }
}
