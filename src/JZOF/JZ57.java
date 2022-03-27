package JZOF;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *��Ϊs����������
 *
 * ����һ����������������һ������s���������в�����������ʹ�����ǵĺ�������s������ж�����ֵĺ͵���s�����������һ�Լ��ɡ�
 *
 * �����л�����ظ�����
 */
public class JZ57 {
    public static void main(String[] args) {
        int [] data = {16,16,18,24,30,32,48};
        System.out.println(Arrays.toString(twoSum3(data,48)));
    }

    /**
     * ����  �س�ʱ
     */
    public static int[] twoSum1(int[] nums, int target) {
        int [] ans = new int[2];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                    ans[0]=nums[i];
                    ans[1]=nums[j];
                    flag=true;
                    break;
                }
            }
            if (flag) break;
        }
        return ans;
    }


    /**
     *��ϣ
     *
     * ʱ�临�Ӷ�O(N^2)
     * �ύ��ʱ80ms
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],target-nums[i]);
        }

        int a=0,b=0;
        for (int i = 0; i < nums.length; i++) {
            int t = map.get(nums[i]);
            if (t>0){
                if (map.containsKey(t)){
                    a=nums[i];b=t;
                    break;
                }
            }
        }
        int [] ans = {a,b};
        return ans;
    }


    /**
     *  ʹ��set ʱ�临�Ӷ�O(n)
     *  �ύ��ʱ  50ms
     *  ���ﻻ��map ���Ż�ʱ�临�Ӷ���һ����
     */
    public static int[] twoSum3(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int [] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target-nums[i])){
                ans[0] = target-nums[i];
                ans[1] = nums[i];
                break;
            }
            set.add(nums[i]);
        }
        return ans;
    }

    /**
     *˫ָ��
     * �ύ ��ʱ2ms
     */
    public static int[] twoSum4(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }

    /**
     *���ֲ���
     */
    public static int[] twoSum5(int[] nums, int target) {
        return new int[0];
    }
}
