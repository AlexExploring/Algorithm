package BitManipulation.numbersThatAppearOnlyOnce;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ŀ������һ���������� nums ����ĳ��Ԫ�ؽ����� һ�� �⣬����ÿ��Ԫ�ض�
 * ǡ���� ���� �������ҳ��������Ǹ�ֻ������һ�ε�Ԫ�ء�
 *
 * ��JZ56II��ͬ
 */
public class LC137 {

    public static void main(String[] args) {
        System.out.println(1 | 1);
    }

    /**
     * ��ϣ��
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            //����num��������ֹ��������Ϊ�Ѿ����ֵĴ����ټ�1������Ϊ0�ټ�1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (value == 1) {
                ans = key;
                break;
            }
        }
        return ans;
    }

    /**
     * ����ȷ��ÿһ��������λ;
     * ���ڳ���ĳһ��Ԫ��ֻ������һ�Σ�����Ԫ�ؾ�������3�ˣ��������ĳһλͳ�������������������� total%3==0;˵��
     * Ҫ�ҵ�����һλΪ0������Ϊ1;
     */
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            //ÿ����һ��numsȷ���𰸵�һλ
            for (int num : nums) {
                total += ((num >> i) & 1);
            }
            //total%3 һ������0��1
            //total%3 != 0 ��˵���𰸵ĵ�i+1λ���ӵ͵��ߣ�Ϊ1
            if (total%3 != 0) {
                //����Ӧ��λ��(��i+1Ϊ(�ӵ͵���))��Ϊ1
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
