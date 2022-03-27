package JZOF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *和为s的连续正数序列
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class JZ57II {
    public static void main(String[] args) {
        int [][] data = findContinuousSequence2(9);
        for (int i = 0; i < data.length; i++) {
            System.out.println(Arrays.toString(data[i]));
        }
    }

    /**
     *暴力  超时
     */
    public static int[][] findContinuousSequence(int target) {
        int [] data = new int[target];
        for (int i = 1; i < target; i++) {
            data[i] = data[i-1]+i;
        }

        ArrayList<int[]> t_res = new ArrayList<>();

        for (int i = 1; i < target/2+1; i++) {
            for (int j = i+1; j < target; j++) {
                if (data[j]-data[i-1]==target){
                    int [] tmp = new int[j-i+1];
                    //这里的k-i 可以在外层加一个index来控制
                    for (int k = i; k <= j; k++) {
                        tmp[k-i] = k;
                    }
                    t_res.add(tmp);
                }
            }
        }

        return t_res.toArray(new int[t_res.size()][]);
    }

    /**
     *暴力 剪枝优化
     */
    public static int[][] findContinuousSequence1(int target) {
        int [] data = new int[target];
        for (int i = 1; i < target; i++) {
            data[i] = data[i-1]+i;
        }

        ArrayList<int[]> t_res = new ArrayList<>();

        //剪枝操作
        for (int i = 1; i < target/2+1; i++) {
            for (int j = i+1; j < target; j++) {
                if (data[j]-data[i-1]==target){
                    int [] tmp = new int[j-i+1];
                    //这里的k-i 可以在外层加一个index来控制
                    for (int k = i; k <= j; k++) {
                        tmp[k-i] = k;
                    }
                    t_res.add(tmp);
                }else if (data[j]-data[i-1]>target) break;
            }
        }

        return t_res.toArray(new int[t_res.size()][]);
    }

    /**
     *双指针
     */
    public static int[][] findContinuousSequence2(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 1, sum = 0; r<target;r++) {
            sum = (l + r) * (r - l + 1) / 2;
            while (sum > target) {
                sum -= l++;
            }

            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }


    /**
     *双指针  耗时 0ms
     */
    public int[][] findContinuousSequence3(int target) {
        List<int[]> res=new ArrayList();
        int i=1;
        while(target>0){
            target=target-i++;
            if(target>0&&target%i==0){
                int[] temp=new int[i];
                for(int j=0;j<i;j++) temp[j]=target/i+j;
                res.add(temp);
            }
        }

        int[][] fin = new int[res.size()][];
        for(int k=fin.length-1;k>=0;k--){
            fin[fin.length-k-1]=res.get(k);
        }
        return fin;
    }

}
