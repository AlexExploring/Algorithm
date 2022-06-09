package Math;

import java.util.Arrays;

public class LC169 {

    /**
     * ����
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Ħ��ͶƱ����
     * ��⣺https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
     *
     * �������׸�Ԫ��Ϊ n1����Ϊ x ��������ͳ��Ʊ���������� Ʊ����=0 ʱ��ʣ�����������һ������ ���������ڣ�
     * �� n1=x �� ���������������У���һ�������� x
     * �� n1!=x : ���������������У����� x ����������Ϊ 0 �������Ϊһ�롣
     */
    public int majorityElement1(int[] nums) {
        int x = 0, votes = 0;

        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }

        return x;
    }
}
