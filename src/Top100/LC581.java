package Top100;

import java.util.Arrays;

/**
 * �����������������
 *
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leet-yhlf/
 */
public class LC581 {

    /**
     * �ڶ��ַ���û����ȫ���
     */

    /**
     * �����鿽��������Ȼ������ԭ������бȽ�
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i <= j && nums[i] == arr[i]) i++;
        while (i <= j && nums[j] == arr[j]) j--;
        return j - i + 1;
    }

    public int findUnsortedSubarray1(int[] nums) {
        //��ʼ��
        int len = nums.length;
        int min = nums[len-1];
        int max = nums[0];
        int begin = 0, end = -1;
        //����
        for(int i = 0; i < len; i++){
            if(nums[i] < max){      //������ά�����ֵ��Ѱ���ұ߽�end
                end = i;
            }else{
                max = nums[i];
            }

            if(nums[len-i-1] > min){    //���ҵ���ά����Сֵ��Ѱ����߽�begin
                begin = len-i-1;
            }else{
                min = nums[len-i-1];
            }

            System.out.println(end+"  "+begin);
        }
        return end-begin+1;
    }
}
