package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ������б�
 *
 * ����һ��δ������������� nums ���ҳ���������������У���Ҫ������Ԫ����ԭ�������������ĳ���
 */
public class LC128 {

    /**
     * ���������ж�
     */
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;

        Arrays.sort(nums);
        int cur = 1,ans = 1;
        for (int i = 1; i < nums.length; i++) {
            // ��ֱͬ������
            if (nums[i] == nums[i-1]) {
                continue;
                // �Ƿ�������������
            }else if (nums[i-1] == nums[i]-1) {
                cur++;
            }else {
                ans = Math.max(cur,ans);
                cur = 1;
            }
        }

        return Math.max(cur,ans);
    }

    /**
     * ʹ��set�洢���е�����
     */
    public int longestConsecutive1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int ans = 0;
        //����Ǳ���nums����leetcode���ύ��ʾ�Ľ�����ٶȺ���������֪��Ϊʲô��
        for (Integer num : numSet) {
            //ȷ��ÿһ���������ж��Ǵ���С�����ֿ�ʼ��
            if (!numSet.contains(num-1)) {
                int curNum = num;
                int curAns = 1;
                while (numSet.contains(++curNum)) {
                    curAns += 1;
                }
                ans = Math.max(ans,curAns);
            }
        }

        return ans;
    }
}
