package Math.BigNumber;

import java.math.BigInteger;

public class BasicOperations {

    public static void main(String[] args) {
        BigInteger a = new BigInteger("1342123412341234123412341");
        BigInteger b = new BigInteger("1234123412342354");

        System.out.println("�ӣ�"+a.add(b));
        System.out.println("��"+a.subtract(b));
        System.out.println("��"+a.multiply(b));
        System.out.println("��"+a.divide(b));
        System.out.println(a.abs());//����ֵ
        System.out.println(a.gcd(b));//�������
        System.out.println(a.multiply(b).divide(a.gcd(b)));//��С������
        System.out.println(a.toString(2));//ת����ָ�����Ƶ������ַ�����ʽ
        System.out.println(a.negate());//ȡ����
        System.out.println("..............................");

    }
}
