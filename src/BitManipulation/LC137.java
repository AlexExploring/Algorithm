package BitManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ŀ������һ���������� nums ����ĳ��Ԫ�ؽ����� һ�� �⣬����ÿ��Ԫ�ض�
 * ǡ���� ���� �������ҳ��������Ǹ�ֻ������һ�ε�Ԫ�ء�
 */
public class LC137 {

    /**
     * map
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
     * λ����
     */
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total+=((num>>i)&1);
            }
            //total%3 һ������0��1
            if (total%3!=0) {
                //����Ӧ��λ����Ϊ1
                ans |= (1<<i);
            }
        }
        return ans;
    }
}
