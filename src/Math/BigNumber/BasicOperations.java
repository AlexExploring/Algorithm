package Math.BigNumber;

import java.math.BigInteger;

public class BasicOperations {

    public static void main(String[] args) {
        BigInteger a = new BigInteger("1342123412341234123412341");
        BigInteger b = new BigInteger("1234123412342354");

        System.out.println("加："+a.add(b));
        System.out.println("减"+a.subtract(b));
        System.out.println("乘"+a.multiply(b));
        System.out.println("除"+a.divide(b));
        System.out.println(a.abs());//绝对值
        System.out.println(a.gcd(b));//最大公因数
        System.out.println(a.multiply(b).divide(a.gcd(b)));//最小公倍数
        System.out.println(a.toString(2));//转化成指定进制的数的字符串形式
        System.out.println(a.negate());//取负数
        System.out.println("..............................");

    }
}
