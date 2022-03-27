package a_books.algorithm_competition.sev.sev_DP_2;

/**
 * DP�Ƶ�+��ż�жϡ�
 * �����������ʱ���������ֵ�ļ��㣬��Ϊֻ������������ߣ������������ڵ�λ�������Ǵ���һ
 * �����λ�õ���߻����ϱ߽�����ת�õ������꣬ͨ��ѡ�����ֵ������ת�����������ֵ
 * �����������Ҳ��ܳ���1������ͨ����ż�жϲ�����
 * ���������������λ�õ�n�㣬�ڣ�n/2+1��λ���ϵ�����
 * �����ż��������Ҫ�жϵ�n�㣬�ڣ�n/2��λ�õ����ֺ͵�n��ڣ�n/2+1��λ�õ����֣�ѡ��ġ�
 * ע���ҵ������±��Ǵ�1��ʼ��*/
import java.util.Scanner;
public class ss2020_8_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = sc.nextInt();
                arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println(n % 2 == 1 ? arr[n][n / 2 + 1] : Math.max(arr[n][n / 2], arr[n][n / 2 + 1]));
    }
}