package Top100;

/**
 * 只出现一次的数字
 *
 * 使用异或运算
 */
public class LC136 {
    public static void main(String[] args) {
        int a = 2,b = 2,c = 3,d = 3,e = 5;
        System.out.println(a^c^a^e^d);
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }
}
