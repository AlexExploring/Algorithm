package a_books.algorithm_competition.sev.sev_DP_1_3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *ά��һ�������ĸ�������
 */
public class LongestIncreasingSubsequence2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] high = new int[n+1];
        for (int i = 1; i <= n; i++) {
            high[i] = scan.nextInt();
        }
        System.out.println(LIS(high,n));
    }
    
    public static int LIS(int [] hihg,int n){
        int len = 1;
        int [] help = new int[n+1];
        help[1] = hihg[1];
        for (int i = 2; i <= n; i++) {
            if (hihg[i]>help[len]){
                help[++len] = hihg[i];
                System.out.println(Arrays.toString(help));
            }else {
//                //���forѭ��������һ�����ֲ������Ż�
//                for (int j = 1; j <= len; j++) {
//                    if (help[j]>hihg[i]){
//                        help[j] = hihg[i];
//                        System.out.println(Arrays.toString(help));
//                        break;
//                    }
//                }
                int j = BinarySearch(help,hihg[i],len);
                System.out.println("j="+j);
                help[j] = hihg[i];
                System.out.println(Arrays.toString(help));
            }
        }
        System.out.println(Arrays.toString(help));
        return len;
    }

    //����help�����е�һ������target���±�
    public static int BinarySearch(int [] help,int target,int len){
        int left = 1,right = len;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (help[mid] <= target){
                left = mid + 1;
            }else {
                right = mid-1;
            }
        }
        return left>len ? -1:left;
    }
}
