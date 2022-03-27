package DP.LC_12_19_0_zfc;

import java.io.*;

//枚举出所有的字符串，分别判断每个字符串是不是回文字符串，并记录长度最长的那个字符串的起点和中点

public class LC5_longestPalindrome {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\ZhangHaixia\\IdeaProjects\\Suanfa\\src\\dongtaiguihua\\LC5_SJ");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String s = br.readLine();
        System.out.println(s);
        String ans = longestPalindrome(s);
        System.out.println(ans);
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        if (s.length()<2) return s;
        int maxlen=1;
        int start=0;
        char [] a = s.toCharArray();

        //枚举所有长度严格大于1的子串a[i...j],
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (isPalindrome(a,i,j) && j-i+1 > maxlen){
                    start=i;maxlen=j-i+1;
                }
            }
        }
        return s.substring(start,start+maxlen);
    }

    /**
     *判断一个字符串是否是回文字符串
     */
    public static boolean isPalindrome(char [] a,int start,int end){
        while (start < end){
            if (a[start] != a[end]){
                return false;
            }
            start++;end--;
        }
        return true;
    }
}
