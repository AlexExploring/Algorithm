package backTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhxspacex
 * @date 2021/1/11 23:49
 */
public class LC22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        LC22 a = new LC22();
        System.out.println(a.generateParenthesis(n));
    }

    List<String> ans = new ArrayList<>();
    int [] a,b;
    public List<String> generateParenthesis(int n) {
        a = new int[2*n];
        b = new int[n];
        for (int i = 0; i < 2 * n; i++) {
            a[i] = i;
        }
        C(2*n,n);
        return ans;
    }

    /**
     *从m个位置中选n个
     */
    public void C(int m,int n){
        int i;
        for(i=n;i<=m;i++) {
            b[n-1] = i-1;
            if(n>1)
                C(i-1,n-1);
            else {
                String s = generate(b);
                if (isValid1(s)) ans.add(s);
            }
        }
    }

    /**
     *生成对应的字符串
     */
    public String generate(int [] b){
        StringBuffer s = new StringBuffer();
        int lenb = b.length;
        int lent = 2*lenb;
        int [] t = new int[lent];
        for (int i = 0; i < lenb; i++) {
            t[b[i]]=1;
        }
        for (int i = 0; i < lent; i++) {
            if (t[i]==1) s.append("(");
            else if (t[i]==0) s.append(")");
        }
        return new String(s);
    }

    /**
     *检查字符串是否有效
     */
    //优化版本，时间复杂度O(N),空间复杂度O(1)
    public boolean isValid1(String s){
        if (s == null || s.length() < 1)
            return false;
        int n = s.length();
        int i = 0;//i标记栈的大小
        for (int j = 0; j < n; j++) {
            char c = s.charAt(j);
            if (c == '('){
                i++;
            }else {
                if (i == 0)
                    return false;
                else
                    i--;
            }
        }
        return i == 0 ? true:false;
    }
}
