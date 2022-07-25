package backTrack.arrangement;

/**
 * ��һ������
 *
 * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
 *
 * ����ϣ����һ�����ȵ�ǰ�������������㡰��һ�����С��Ķ��塣���ֻ��Ҫ������ġ���������ǰ��ġ�С��������������
 * �õ�һ��������������� 123456���� 5 �� 6 �������ܵõ�һ��������� 123465��
 * ���ǻ�ϣ����һ�������ӵķ��Ⱦ����ܵ�С�����������㡰��һ�������뵱ǰ���н��ڡ���Ҫ��Ϊ���������Ҫ��������Ҫ��
 * �ھ����ܿ��ҵĵ�λ���н�������Ҫ�Ӻ���ǰ���ҽ�һ�� ������С�ġ������� ��ǰ��ġ�С�������������� 123465����һ
 * ������Ӧ�ð� 5 �� 4 ���������ǰ� 6 �� 4 ������������������ǰ�����Ҫ�������������������������Ϊ��������
 * ���о�����С�����С��� 123465 Ϊ�������Ȱ�����һ�������� 5 �� 4���õ� 123564��Ȼ����Ҫ�� 5 ֮���������Ϊ��
 * �򣬵õ� 123546����Ȼ 123546 �� 123564 ��С��123546 ���� 123465 ����һ�����С�
 *
 * ���Ͼ�������һ�����С��ķ������̡�
 */
public class LC31 {

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,5,6,4};
        new LC31().nextPermutation(nums);
    }

    /**
     * ���Դ������ظ����ֵ����
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //�Ӻ���ǰ�ҵ� ��һ��ʹnums[i] < nums[i+1]��i, һ�������ܴ��С��
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //i >= 0��˵����һ�����д���
        if (i >= 0) {
            int j = nums.length - 1;
            //�Ӻ���ǰ ��һ��ʹnums[i] < nums[j]��j�� һ��������С�Ĵ���
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        //��ʱ����i+1��nums.length-1 �ض�Ϊ��������ֱ��ʹ��˫ָ�룬��ת��һ����ʹ��Ϊ����
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * ��nums��start��ʼ����nums��β������ת
     */
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}