package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * �ϲ�����
 */
public class LC56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        //����ÿ�������start�Ӵ�С����,���ݷ�ΧС������ֱ��v1[0]-v2[0],���õ������
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int i = 1,start = intervals[0][0],end = intervals[0][1];
        List<int[]> merged = new ArrayList<>();

        //�ϲ�
        while (i < intervals.length){
            // ��һ�������end���ڵ��ڵ�ǰ�����start����end�Ƿ���Ҫ�ı�
            if (end >= intervals[i][0]) {
                // ��һ�������endС�ڵ��ڵ�ǰ�����end���ı�end��ֵΪ��ǰ�����end
                if (end <= intervals[i][1]){
                    end = intervals[i][1];
                }
            }else { // ��һ�������endС�ڵ�ǰ�����start����ǰ�����ǰ������䲻����ϲ�Ҫ�󣬽�ǰ�������ϲ�����
                merged.add(new int[]{start,end});
                //����start��end
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }
        merged.add(new int[]{start,end});

        //listת�浽������
       return merged.toArray(new int[merged.size()][]);
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