package backTrack;

/**
 * @author zhxspacex
 * @date 2021/1/27 19:46
 */

import java.util.Scanner;

/**
 *排列序列
 */
/**
 *有错误
 */
public class LC60 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        LC60 b = new LC60();
        System.out.println("ans="+b.getPermutation(n,k));
    }

    static StringBuffer tans = new StringBuffer();
    static int t = 0;
    public static String getPermutation(int n, int k) {
        int [] a = new int[n];
        int [] book = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        return backTrack(book,a,n,k);
    }

    static String ans = new String();
    public static String backTrack(int [] book,int [] a,int n,int k){
        if (tans.length()==n){
            t++;
            if (t==k){
                ans = new String(tans);
                return ans;
            }

        }

        for (int i = 0; i < n&&t<k; i++) {
            if (book[i]==0){
                book[i]=1;
                tans.append(a[i]);
                backTrack(book,a,n,k);
                tans.deleteCharAt(tans.length()-1);
                book[i]=0;
            }
        }
        return ans;
    }
}
