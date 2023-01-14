package TwoPointers.array;

/**
 * ��Ŀ������֮��II
 * 
 * ����һ���±�� 1 ��ʼ����������numbers ���������Ѱ� �ǵݼ�˳������ ��
 * ������������ҳ��������֮�͵���Ŀ����target �����������������������
 * �ֱ��� numbers[index1] �� numbers[index2] ���� 1 <= index1 < index2 <= numbers.length ��
 *
 * �Գ���Ϊ 2 ���������� [index1, index2] ����ʽ�����������������±� index1 �� index2��
 *
 * ����Լ���ÿ������ ֻ��ӦΨһ�Ĵ� �������� ������ �ظ�ʹ����ͬ��Ԫ�ء�
 *
 * ������ƵĽ����������ֻʹ�ó������Ķ���ռ䡣
 */
public class LC167 {

    /**
     * ˫��ѭ��������ö��
     */
    public int[] twoSum(int[] numbers, int target) {
        int [] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    ans[0] = i + 1;ans[1] = j + 1;
                }
            }
        }

        return ans;
    }

    /**
     * ˫ָ��
     */
    public int[] twoSum1(int[] numbers, int target) {
        int l = 0,r = numbers.length - 1,sum;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum > target) r--;
            else if (sum < target) l++;
            else {
                //����±��0��ʼ����left��right������Ҫ��1
                return new int[]{l + 1,r + 1};
            }
        }

        return new int[0];
    }
}