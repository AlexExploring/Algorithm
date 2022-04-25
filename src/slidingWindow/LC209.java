package slidingWindow;

import java.util.Arrays;

/**
 * �ʹ��ڵ���target�����������
 */
public class LC209 {


    /**
     * ������
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len==0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum+=nums[j];
                if (sum>=target) {
                    ans = Math.min(ans,j-i+1);
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * ǰ׺��+���ֲ���
     *
     *  ʱ�临�Ӷ�ΪO(log(n))
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int len = nums.length;
        if (len==0) return 0;
        int ans = Integer.MAX_VALUE;

        // Ϊ�˷�����㣬�� size = n + 1
        // sums[i] = total ��ζ��ǰ i��Ԫ�ص�ǰ׺��Ϊ total
        int [] sums = new int[len+1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i-1]+nums[i-1];
        }

        //sums[j]-sums[i] >= target
        for (int i = 1; i <= len; i++) {
            // ��Ϊi�ǰ����ڼ���ڵģ�������Ҫtarget+sums[i-1]
            int ser = target+sums[i-1];
            //���±�i��ʼ��sums[bound]>=ser ��
            int bound = Arrays.binarySearch(sums,ser);
            if (bound==-1) bound = 0;
            if (bound<=len) ans = Math.min(ans,(bound-(i-1)));
        }

        return ans==Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * �������� ��������
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        if (len==0) return 0;
        int ans = Integer.MAX_VALUE;

        int start = 0,end = 0;
        int sum = 0;
        while (end<len) {
            sum+=nums[end];
            //ֵҪsum >= target ����Ҫѭ������ans
            while (sum>=target) {
                ans = Math.min(ans,end-start+1);
                sum-=nums[start];
                start++;
            }
            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}