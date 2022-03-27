package JZOF.bit_manipulation;

import java.util.Scanner;

public class JZ15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(hammingWeight1(scan.nextInt()));
    }

    public static int hammingWeight1(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n&1)!=0) {
                ret++;
            }
            n = n>>1;
        }
        return ret;
    }

    public static int hammingWeight2(int n) {
        // HD, Figure 5-2
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }


    /**
     *˼·���ⷨ
     *
     * �۲�������㣺n&(n - 1)����������ǡΪ�� n �Ķ�����λ�е����λ�� 1 ��Ϊ 0 ֮��Ľ����
     *
     * �磺6&(6-1) = 4, 6 = (110)_2, 4 = (100)_2,������ 4��Ϊ�� 6 �Ķ�����λ�е����λ�� 1 ��Ϊ 0 ֮��Ľ����
     *
     * �������ǿ����������λ��������ʼ������ǵļ����̣���ʵ�ʴ����У����ǲ����õ�ǰ�� n
     * �� n - 1�������㣬ֱ�� n ��Ϊ 0 ���ɡ���Ϊÿ�������ʹ�� n �����λ�� 1 ����ת�������������͵��� n �Ķ�����λ�� 1 �ĸ�����
     */
    public static int hammingWeight3(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
