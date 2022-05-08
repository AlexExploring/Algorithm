package BinarySearch;

/**
 * ����������ֻ����һ�ε�����
 */
public class LC540 {

    /**
     * λ����
     * ʱ�临�Ӷ�O(n),
     */
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }


    /**
     * ��ĿҪ��ֻ��һ��������һ�Σ�����������������
     * ʱ�临�Ӷ�O(n/2)
     */
    public int singleNonDuplicate1(int[] nums) {
        int len = nums.length;
        if (len <= 1) return nums[0];

        for (int i = 1; i < nums.length; i+=2) {
            if (nums[i] != nums[i-1]) return nums[i-1];
        }

        // ˵�����һ����������һ��
        return nums[len-1];
    }

    /**
     * ˼·�����ַ���
     * ��������������ģ������������ͬ��Ԫ��һ�����ڡ������±� x ��ߵ��±� y�����
     * nums[y]=nums[y+1]���� y һ����ż���������±� x �ұߵ��±� z�����
     * [z + 1]nums[z]=nums[z+1]���� z һ����������ֻ����һ�ε����ֵ��±�x��
     * ����ͬԪ�ؿ�ʼ�±����ż�Էֽ磬���ʹ���ֲ��ҵķ���Ѱ���±�x��
     *
     * ע�⣺1.�� mid ��ż��ʱ��mid+1=mid?1��2.�� mid ������ʱ��mid?1=mid?1��
     *
     * ���mid��ż�����������Ļ�������nums[mid] ��= nums[mid+1]��nums[mid] != nums[mid-1]�� ,
     * ˵��x�϶�����mid���Ҳ࣬����r=mid
     *
     * ʱ�临�Ӷ�O(log(n))
     */
    public int singleNonDuplicate2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == nums[mid ^ 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
