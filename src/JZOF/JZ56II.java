package JZOF;

import java.util.Arrays;
import java.util.HashMap;

/**
 *���������ֳ��ֵĴ���II
 *
 * ��һ������ nums �г�һ������ֻ����һ��֮�⣬�������ֶ����������Ρ����ҳ��Ǹ�ֻ����һ�ε����֡�
 */
public class JZ56II {

    /**
     *��ϣ ����
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i],2);
            else map.put(nums[i],1);
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key)==1) {
                res = key;break;
            }
        }
        return res;
    }

    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i+1<nums.length && nums[i]==nums[i+1]) {
                i+=2;
                continue;
            }
            res = nums[i];
        }
        return res;
    }

    /**
     *λ����
     *
     * ��java��int������32λ��������Ҫͳ������������ĳһλ�õĺ��ܲ��ܱ�3������
     * ������ܱ�3������˵���Ǹ�ֻ����һ�ε����ֵĶ��������Ǹ�λ����1������32λ
     * ȫ��ͳ����Ϊֹ
     *
     * <<< �Ƿ�ֹ �빬�������и������ڣ���Ȼ������ȷ����
     */
    public int singleNumber2(int[] nums) {
        //���յĽ��ֵ
        int res = 0;
        //int������32λ��ͳ��ÿһλ1�ĸ���
        for (int i = 0; i < 32; i++) {
            //ͳ�Ƶ�iλ��1�ĸ���
            int oneCount = 0;
            for (int j = 0; j < nums.length; j++) {
                oneCount += (nums[j] >>> i) & 1;
            }
            //���1�ĸ�������3�ı�����˵���Ǹ�ֻ����һ�ε�����
            //�Ķ�����λ������һλ��1
            if (oneCount % 3 == 1)
                res |= 1 << i;
        }
        return res;
    }

    /**
     *��չ1 ���ֻ��һ�����ֳ���һ�Σ��������ֶ�����ż���Σ�����ֻ��Ҫ�������������һ�鼴��
     *
     * a^a=0 �κ����ֺ��Լ��������0
     * a^0=a �κ����ֺ�0��������Լ�
     * a^b^c=a^c^b ���������н�����
     */

    /**
     *��չ2 ���ֻ��һ�����ֳ���һ�Σ��������ֶ����������Σ����ǿ���������Ĵ��������
     */
    // n�ǳ��ֵĴ���
    public int findOnce(int[] nums, int n) {
        int bitLength = 32;
        int res = 0;
        for (int i = 0; i < bitLength; i++) {
            int oneCount = 0;
            for (int j = 0; j < nums.length; j++) {
                oneCount += (nums[j] >>> i) & 1;
            }
            if (oneCount % n != 0)
                res |= (1 << i);
        }
        return res;
    }
}
