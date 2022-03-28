package tx50;

import java.util.Arrays;

/**
 * ´æÔÚÖØ¸´ÔªËØ
 */
public class LC217 {
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]) {
                return true;
            }
        }

        return false;
    }
}
