package JZOF;

import java.util.Arrays;
import java.util.HashMap;

/**
 *数组中数字出现的次数II
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class JZ56II {

    /**
     *哈希 暴力
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i],2);
            else map.put(nums[i],1);
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key)==1) {
                res = key;break;
            }
        }
        return res;
    }

    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i+1<nums.length && nums[i]==nums[i+1]) {
                i+=2;
                continue;
            }
            res = nums[i];
        }
        return res;
    }

    /**
     *位运算
     *
     * 在java中int类型是32位，我们需要统计所有数字在某一位置的和能不能被3整除，
     * 如果不能被3整除，说明那个只出现一次的数字的二进制在那个位置是1……把32位
     * 全部统计完为止
     *
     * <<< 是防止 入宫数据中有负数存在，依然可以正确运行
     */
    public int singleNumber2(int[] nums) {
        //最终的结果值
        int res = 0;
        //int类型有32位，统计每一位1的个数
        for (int i = 0; i < 32; i++) {
            //统计第i位中1的个数
            int oneCount = 0;
            for (int j = 0; j < nums.length; j++) {
                oneCount += (nums[j] >>> i) & 1;
            }
            //如果1的个数不是3的倍数，说明那个只出现一次的数字
            //的二进制位中在这一位是1
            if (oneCount % 3 == 1)
                res |= 1 << i;
        }
        return res;
    }

    /**
     *扩展1 如果只有一个数字出现一次，其他数字都出现偶数次，我们只需要把所有数字异或一遍即可
     *
     * a^a=0 任何数字和自己异或结果是0
     * a^0=a 任何数字和0异或还是他自己
     * a^b^c=a^c^b 异或运算具有交换律
     */

    /**
     *扩展2 如果只有一个数字出现一次，其他数字都出现奇数次，我们可以用下面的代码来解决
     */
    // n是出现的次数
    public int findOnce(int[] nums, int n) {
        int bitLength = 32;
        int res = 0;
        for (int i = 0; i < bitLength; i++) {
            int oneCount = 0;
            for (int j = 0; j < nums.length; j++) {
                oneCount += (nums[j] >>> i) & 1;
            }
            if (oneCount % n != 0)
                res |= (1 << i);
        }
        return res;
    }
}
