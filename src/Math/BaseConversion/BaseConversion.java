package Math.BaseConversion;

import java.math.BigInteger;

public class BaseConversion {
    public static void main(String[] args) {
        String st = Integer.toString(5, 2); // 把i当做10进制的数转成radix进制的st(base <= 35).
        System.out.println(st);
        int num = Integer.parseInt("1111111111111111111111111111101",2);//// 把s当做radix进制，转成10进制的int(pars
        // eInt有两个参数,第一个为要转的字符串,第二个为说明是什么进制).
        System.out.println(num);
//        BigInteger m = new BigInteger(st, 2); // st是字符串，base是st的进制.
//        System.out.println(m);
    }

    //进制转换
    public static String base(int n,int b){
        StringBuffer res = new StringBuffer();
        while (n!=0){
            res.append(get(n%b));
            n/=b;
        }
        return new String(res.reverse());
    }

    public static char get(int x){
        if (x<=9) return (char) (x + '0');
        return (char) (x-10+'A');
    }
}
