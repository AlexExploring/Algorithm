package bishi.dj;

import java.util.*;

class Solution {

    /* Write Code Here */
    public boolean containsNearbyDuplic(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j > i+k) break;
                if (nums[i] == nums[j]) return true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int nums_size = 0;
        nums_size = scan.nextInt();
        int[] nums = new int[nums_size];
        for(int nums_i = 0; nums_i < nums_size; nums_i++) {
            nums[nums_i] = scan.nextInt();
        }

        int k = scan.nextInt();

        System.out.println(new Solution().containsNearbyDuplic(nums, k));
    }
}
