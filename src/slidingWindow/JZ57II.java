package slidingWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列（至少含有两个数）
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class JZ57II {

    /**
     * 暴力 剪枝优化
     */
    public static int[][] findContinuousSequence(int target) {
        //data[i] 是data前[0,i]个数的和
        int [] data = new int[target];
        for (int i = 1; i < target; i++) {
            data[i] = data[i-1]+i;
        }

        ArrayList<int[]> res = new ArrayList<>();

        //外层循环枚举右边界，内层循环是左边界
        for (int i = 1; i < target/2+1; i++) {
            for (int j = i+1; j < target; j++) {
                int t = data[j] - data[i - 1];
                if (t == target){
                    int[] tmp = new int[j-i+1];
                    //将符合要求的数据填入temp中
                    for (int k = i; k <= j; k++) {
                        tmp[k-i] = k;
                    }
                    //将temp加入到最终的结果中
                    res.add(tmp);
                }else if (t > target) break;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 双指针,滑动窗口
     */
    public int[][] findContinuousSequence1(int target) {
        List<int[]> res = new ArrayList<>();
        int l = 1, r = 2, t = 3;

        while(l < r) {
            if(t == target) {
                int[] ans = new int[r - l + 1];
                for(int k = l; k <= r; k++)
                    ans[k - l] = k;
                res.add(ans);
            }
            if(t >= target) {
                t -= l;
                //将l移除窗口
                l++;
            } else {
                //将r加入窗口
                r++;
                t += r;
            }
        }

        return res.toArray(new int[0][]);
    }
}
