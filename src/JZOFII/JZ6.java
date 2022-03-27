package JZOFII;

public class JZ6 {

    /**
     * ±©Á¦
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
     * Ë«Ö¸Õë
     */
    public int[] twoSum1(int[] numbers, int target) {
        int [] ans = new int[2];
        int left = 0,right = numbers.length-1;
        while (left<right) {
            if (numbers[left]+numbers[right]>target) right--;
            else if (numbers[left]+numbers[right]<target) left++;
            else {
                ans[0] = left;ans[1] = right;
                break;
            }
        }
        return ans;
    }
}
