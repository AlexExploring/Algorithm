package Top100;

public class LC75 {
    public void sortColors(int[] nums) {
        int a = 0,b = 1,c = 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) a++;
            else if(nums[i]==1) b++;
            else c++;
        }

        for (int i = 0; i < a; i++) nums[i] = 0;
        for (int i = a; i < a+b; i++) nums[i] = 1;
        for (int i = a+b; i < a+b+c; i++) {
            System.out.println(i);
            nums[i] = 2;
        }
    }

    public void sortColors1(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
}
