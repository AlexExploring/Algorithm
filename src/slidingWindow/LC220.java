package slidingWindow;

import java.math.BigInteger;
import java.util.TreeSet;

/**
 * ֵ���±�֮��ڸ����ķ�Χ��
 */
public class LC220 {

    /**
     * ����һ:ʹ��BigInteger�������������Χ���������
     * ʱ�临�Ӷ�Ϊ O(n) ����ʱ
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        BigInteger T = BigInteger.valueOf(t);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int compValAns = BigInteger.valueOf(nums[i]).subtract(BigInteger.valueOf(nums[j])).abs().compareTo(T);
                // �±�֮��
                int compIndAns = Math.abs(i-j);
                if (compValAns <= 0 && compIndAns <= k) return true;
            }
        }
        return false;
    }

    /**
     * ���������������� + ���򼯺�
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            // set.ceiling(): Returns the least element in this set greater
            // than or equal to the given element, or {@code null} if there
            // is no such element.
            // ���Ǽ�鴰�����Ƿ����Ԫ���������� [nums[i] - t, nums[i] + t] �м��ɡ�
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            // ��Ϊ�±��Ǵ�0��ʼ������ i >= k, ά��һ����СΪk�Ļ�������
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
