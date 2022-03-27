package JZOFII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * �����к�Ϊ0��������
 */
public class JZ7 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    /**
     * ����1�����ݷ� ��ʱ
     */
    public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       backTrack(nums,0,0);
       return ans;
    }

    public void backTrack(int [] nums,int total,int begin){
        if ((total<0||total>0)&&tans.size()>=3) return;
        if (total==0&&tans.size()==3){
            ans.add(new ArrayList<>(tans));
        }
        for (int i = begin; i < nums.length; i++) {
            if (i>begin&&(nums[i]==nums[i-1])) continue;
            tans.add(nums[i]);
            total+=nums[i];
            backTrack(nums,total,i+1);
            total-=nums[i];
            tans.remove(tans.size()-1);
        }
    }

    /**
     * ����2
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums==null||nums.length<3) return ans;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            //��� nums[i]���� 0��������֮�ͱ�Ȼ�޷����� 0������ѭ��
            if (nums[i]>0) break;
            //��� nums[i] == nums[i?1]����˵���������ظ����ᵼ�½���ظ�������Ӧ������
            if (i>0&&nums[i]==nums[i-1]) continue;
            int l = i+1,r = len-1;
            while (l<r) {
                int sum = nums[i]+nums[l]+nums[r];
                if (sum==0) {
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    // �� sum == 0 ʱ��nums[L] == nums[L+1] ��ᵼ�½���ظ���Ӧ��������L++,rͬ��
                    while (l<r&&nums[l]==nums[l+1]) l++;
                    while (r>l&&nums[r]==nums[r-1]) r--;
                    l++;r--;
                }else if (sum>0) r--;
                else l++;
            }
        }

        return ans;
    }
}
