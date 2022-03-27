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
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive1(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length==0) return 0;
        //ȥ��
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //�Ž�����
        int [] t = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            t[i]=integer;
            i++;
        }
        if (t.length==1) return 1;
        //����
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
     *Ч�����
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
    public static int longestConsecutive2(int[] nums) {

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
