package Math;

/**
 * 数字序列中某一位数字
 */
public class LC400 {
    public static void main(String[] args) {

    }

    public int findNthDigit(int n) {
        // n所在数字的位数
        int digit = 1;
        // 数字范围开始的第一个数
        long start = 1;
        // 占多少位
        long count = 9;

        while(n > count){
            n -= count;
            digit++;
            //下一个数字范围的起始
            start *= 10;
            //下一个范围内的数位数量计算
            count = digit * start * 9;
        }

        // 指定位数的数字具体在哪一个数中
        long num = start + (n - 1) / digit;

        //确定所求数位在 numnum 的哪一数位
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
