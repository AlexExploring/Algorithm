package a_books.algorithm_competition.nin.nin_Str_4;

import java.util.Scanner;

/**
 *直接套用kmp模板
 */
public class hdu2087_1 {
    static int MAXN = 1005;
    static int [] next = new int[MAXN];
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = new String();
        String p = new String();
        while (scan.hasNext()){
            s = scan.next();
            p = scan.next();
            ans=0;
            KmpSearch(s,p);
            System.out.println(ans);
        }
    }

    public static void getFail(String p){
        next[0] = 0;
        next[1] = 0;
        int p_len = p.length();
        for (int i = 1; i < p_len; i++) {
            int j = next[i];
            while (j!=0&&p.charAt(i)!=p.charAt(j)) j = next[j];
            next[i+1] = (p.charAt(i)==p.charAt(j)) ? j+1:0;
        }
    }

    public static void KmpSearch(String s, String p)
    {
        int last = -1;
        int s_len = s.length(),p_len = p.length();
        getFail(p);
        int j = 0;

        for (int i = 0; i < s_len; i++) {
            System.out.println("i="+i+"j="+j);
            while (j!=0&&s.charAt(i)!=p.charAt(j)) {
                System.out.println("j="+j);
                j=next[j];
            }
            if (s.charAt(i)==p.charAt(j)) j++;
            if (j==p_len){
                if (i-last>=p_len){
                    ans++;
                    last = i;
                    j=0;
                }
            }
        }
    }
}
