package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������
 */
public class LC525 {

    public int findMaxLength(int[] nums) {
        int ans = 0,count = 0;
        //��ϣ��洢���� counter ��ÿ��ȡֵ��һ�γ��ֵ��±�
        Map<Integer,Integer> map = new HashMap<>();
        //���ڿյ�ǰ׺��Ԫ�غ�Ϊ 0������ڱ���֮ǰ�������ڹ�ϣ���д����ֵ�� (0,-1)
        map.put(count,-1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] ==  1) {
                count++;
            }else count--;

            if (map.containsKey(count)) {
                ans = Math.max(ans,i-map.get(count));
            }else {
                map.put(count,i);
            }
        }

        return ans;
    }
}
