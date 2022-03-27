package a_books.algorithm_competition.sev.sev_DP_1_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *Ӳ������
 * ��n��Ӳ�ң���ֵ�ֱ�Ϊv1��v2��...vn�������ޣ�����Ǹ�����sѡ��Ӳ�ң�ʹ���Ϊs��Ҫ��������ٵ�Ӳ�����
 */
public class coin {
    static int money = 20000;//�����
    static int value = 5;//5��Ӳ��
    static int [] type = {1,5,10,25,50};//5�����
    static int [] Min = new int[money];

    public static void main(String[] args) {
        solve();
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        System.out.println(Min[s]);
    }

    public static void solve(){
        Arrays.fill(Min,Integer.MAX_VALUE);
        Min[0]=0;
        for (int i = 0; i < value; i++) {
            for (int j = type[i]; j < money; j++) {
                Min[j] = Math.min(Min[j], Min[j-type[i]]+1);
            }
        }
    }
}
