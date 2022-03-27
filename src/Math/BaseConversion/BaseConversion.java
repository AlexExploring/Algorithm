package Math.BaseConversion;

import java.math.BigInteger;

public class BaseConversion {
    public static void main(String[] args) {
        String st = Integer.toString(5, 2); // ��i����10���Ƶ���ת��radix���Ƶ�st(base <= 35).
        System.out.println(st);
        int num = Integer.parseInt("1111111111111111111111111111101",2);//// ��s����radix���ƣ�ת��10���Ƶ�int(pars
        // eInt����������,��һ��ΪҪת���ַ���,�ڶ���Ϊ˵����ʲô����).
        System.out.println(num);
//        BigInteger m = new BigInteger(st, 2); // st���ַ�����base��st�Ľ���.
//        System.out.println(m);
    }

    //����ת��
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
