package AdvancedDataStructure.UnionFind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *最长连续列表
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度
 */
public class LC128 {
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive1(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length==0) return 0;
        //去重
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //放进数组
        int [] t = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            t[i]=integer;
            i++;
        }
        if (t.length==1) return 1;
        //排序
        Arrays.sort(t);
        int flag = t[0],tmax = 1,max = 0;
        for (int j = 1; j < t.length; j++) {
            if (t[j]-1==flag){
                tmax++;
                flag=t[j];
                System.out.println(tmax +"  "+flag);
            }else {
                flag=t[j];tmax=1;
            }
            max = Math.max(tmax,max);
        }
        return max;
    }

    /**
     *效率最高
     */
    public static int longestConsecutive1(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        Arrays.sort(nums);
        int len=nums.length;
        int count = 1;
        int res=0;
        for(int i= 1;i<len;i++){
            if(nums[i]==nums[i-1]){ //如果和上一个相同，直接跳过本次循环
                continue;
            }
            if((nums[i]-nums[i-1])==1){
                count++;
            }else{
                res=Math.max(count,res);
                count=1;
            }
        }
        return Math.max(res,count);
    }

    /**
     *官方题解
     */
    public static int longestConsecutive2(int[] nums) {

        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {//当某一个数-1的数不存在，说明如果要求连续的序列，则只能从当前点开始
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
