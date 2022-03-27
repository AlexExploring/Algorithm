package JZOF.math;

/**
 * 数字序列中某一位数字
 */
public class JZ44 {
    public static void main(String[] args) {

    }

    public int findNthDigit(int n) {
        int digit = 1;   // n所在数字的位数
        long start = 1;  // 数字范围开始的第一个数
        long count = 9;  // 占多少位
        while(n > count){
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        // 指定位数的数字具体在哪一个数中
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
