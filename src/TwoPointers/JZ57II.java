package TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 *  title：和为s的连续正数序列
 *
 *  题目：输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *  序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  数据范围：1 <= target <= 10^5
 */
public class JZ57II {

    public static void main(String[] args) {
        new JZ57II().findContinuousSequence2(9);
    }

    /**
     * 方法一：枚举+暴力（由于题目要求序列长度至少大于 2，,所以枚举的上界应该为(target/2)
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        //r为枚举的上界
        int sum = 0, r = (target / 2);

        //由于是正整数，所以枚举的起点为1
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
     * 方法2：双指针+求和公式
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
     * 双指针,滑动窗口
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
                //将r加入窗口
                sum += ++r;
            } else {
                //将l移除窗口
                sum -= l++;
            }
        }

        return res.toArray(new int[0][]);
    }
}