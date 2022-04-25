package TwoPointers;

/**
 * ��Ŀ������֮��II
 *
 */
public class LC167 {

    /**
     * ����
     */
    public int[] twoSum(int[] numbers, int target) {
        int [] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i]+numbers[j]==target) {
                    ans[0] = i;ans[1] = j;
                }
            }
        }
        return ans;
    }

    /**
     * ˫ָ��
     */
    public int[] twoSum1(int[] numbers, int target) {
        int left = 0,right = numbers.length-1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) right--;
            else if (numbers[left] + numbers[right] < target) left++;
            else {
                //����±��0��ʼ����left��right������Ҫ��1
                return new int[] {left+1,right+1};
            }
        }
        return new int[0];
    }
}
