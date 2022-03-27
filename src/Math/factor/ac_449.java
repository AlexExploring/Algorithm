package Math.factor;

import java.util.Scanner;

/**
 *�������ֽ�
 *
 * ��֪������ n ��������ͬ�������ĳ˻���������ϴ���Ǹ�������
 *
 * �����ʽ
 * ����ֻ��һ�У�����һ�������� n��
 *
 * �����ʽ
 * ���ֻ��һ�У�����һ�������� p�����ϴ���Ǹ�������
 *
 * ���ݷ�Χ
 * 6��n��2?109
 *
 *
 * ����Լ�����ǳɶԳ��ֵģ���� d �� n ��Լ������ô n/d Ҳ�� n ��Լ����
 *
 * ���ǿ���ֻö�ٽ�С��Լ����Ȼ�������ϴ��Լ�����ɡ���ô��Ҫö�ٵķ�Χ���㣺 d��n/d���� d�ܡ�n�����ֻ��Ҫö�� ��n �Ρ�
 */
public class ac_449 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(getMaxPrimeFactor(scan.nextInt()));
    }

    public static int getMaxPrimeFactor(int n){
        int ans = 0;
        //for (int i = 2;; i ++ )
        for (int i = 2;i<=Math.sqrt(n); i ++ ){
            if (n % i == 0) {
                ans = n/i;
                break;
            }
        }
        return ans;
    }
}
