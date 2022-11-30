package TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 *  title����Ϊs��������������
 *
 *  ��Ŀ������һ�������� target ��������к�Ϊ target ���������������У����ٺ�������������
 *  �����ڵ�������С�������У���ͬ���а����׸����ִ�С�������С�
 *
 *  ���ݷ�Χ��1 <= target <= 10^5
 */
public class JZ57II {

    public static void main(String[] args) {
        new JZ57II().findContinuousSequence2(9);
    }

    /**
     * ����һ��ö��+������������ĿҪ�����г������ٴ��� 2��,����ö�ٵ��Ͻ�Ӧ��Ϊ(target/2)
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        //rΪö�ٵ��Ͻ�
        int sum = 0, r = (target / 2);

        //������������������ö�ٵ����Ϊ1
        for (int i = 1; i <= r; i++) {
            for (int j = i; ; j++) {
                sum += j;
                if (sum > target) {
                    sum = 0;
                    break;
                } else if (sum == target) {
                    int[] tem = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        tem[k - i] = k;
                    }
                    res.add(tem);
                    sum = 0;
                    break;
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    /**
     * ����2��˫ָ��+��͹�ʽ
     */
    public int[][] findContinuousSequence1(int target) {
        List<int[]> res = new ArrayList<>();
        int l = 1,r = 2;

        while (l < r) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] tem = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    tem[i - l] = i;
                }
                res.add(tem);
                l++;
            }else if (sum < target) {
                r++;
            }else {
                l++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    /**
     * ˫ָ��,��������
     */
    public int[][] findContinuousSequence2(int target) {
        List<int[]> res = new ArrayList<>();
        int l = 1, r = 2, sum = 3;

        while(l < r) {
            if(sum == target) {
                int[] ans = new int[r - l + 1];
                for(int k = l; k <= r; k++) {
                    ans[k - l] = k;
                }
                res.add(ans);
                sum -= l++;
            }else if(sum < target) {
                //��r���봰��
                sum += ++r;
            } else {
                //��l�Ƴ�����
                sum -= l++;
            }
        }

        return res.toArray(new int[0][]);
    }
}