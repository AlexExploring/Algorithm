package AdvancedDataStructure.UnionFind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *������б�
 *
 * ����һ��δ������������� nums ���ҳ���������������У���Ҫ������Ԫ����ԭ�������������ĳ���
 */
public class LC128 {
    /**
     *Ч�����
     */
    public int longestConsecutive(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        Arrays.sort(nums);
        int len=nums.length;
        int count = 1;
        int res=0;
        for(int i= 1;i<len;i++){
            if(nums[i]==nums[i-1]){ //�������һ����ͬ��ֱ����������ѭ��
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
     *�ٷ����
     */
    public int longestConsecutive1(int[] nums) {

        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {//��ĳһ����-1���������ڣ�˵�����Ҫ�����������У���ֻ�ܴӵ�ǰ�㿪ʼ
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
