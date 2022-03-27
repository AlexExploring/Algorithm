package JZOF;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class JZ61 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(isStraight(new int[]{4,7,5,9,2}));
    }

    /**
     * 任何题目
     * 1.判断输入的数据是否需要处理
     * 2.逆向考虑
     */
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0,pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) zero++;
            else if (i!=0){
                for (int j = i-1; j >=0 ; j--) {
                    if (nums[j]==nums[i]) return false;
                    if (nums[j]!=0) {
                        pos += nums[i]-nums[j]-1;
                        break;
                    }
                }
            }
        }
        return zero>=pos;
    }
}
