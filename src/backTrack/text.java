package backTrack;

import java.util.Arrays;

/**
 * @author zhxspacex
 * @date 2021/1/11 22:31
 */
public class text {
    static int N = 5;
    static int M = 3;
    static int[] a= new int[]{1,2,3,4,5};
    static int[] b = new int[M];

    public static void main(String[] args){
        text a = new text();
        a.C(N,M);
    }

    public void C(int m,int n){
        int i,j;
        for(i=n;i<=m;i++) {
            b[n-1] = i-1;
            if(n>1)
                C(i-1,n-1);
            else {
                System.out.println(Arrays.toString(b));
                System.out.println(generate(b,3));
            }
        }
    }

    public String generate(int [] t1,int n){
        StringBuffer s = new StringBuffer();
        int [] t = new int[6];
        for (int i = 0; i < 3; i++) {
            t[t1[i]]=1;
        }
        for (int i = 0; i < 6; i++) {
            if (t[i]==0) s.append(")");
            else if (t[i]==1) s.append("(");
        }
        return new String(s);
    }
}
