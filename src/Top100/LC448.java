package Top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 */
public class LC448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num-1)%n;
            nums[x]+=n;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=n) ans.add(i+1);
        }

        return ans;
    }
}

