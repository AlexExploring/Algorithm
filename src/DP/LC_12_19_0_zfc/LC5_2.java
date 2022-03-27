package DP.LC_12_19_0_zfc;

import java.io.*;
import java.util.Scanner;

//枚举所有可能的回文子串的中心位置；
//中心位置可能是一个字符，也可能是两个相邻的字符

//中心扩展法
public class LC5_2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        System.out.println(countSubstrings(s));
    }
    public static String countSubstrings(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxlen = 1;
        int start = 0;
        char[] a = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            int oddlen = isOk(a, i, i); //奇数
            int eveneln = isOk(a, i, i + 1);// isOk(a, i, i+1); //偶数
            int curMaxlen=Math.max(oddlen,eveneln);
            if (curMaxlen > maxlen){
                maxlen = curMaxlen;
                start = i-(maxlen-1)/2;
            }
        }
        return s.substring(start,start+maxlen);
    }

    public static int isOk(char[] str,int left,int right) {
        //当p=q的时候，回文中心是一个字符，回文串的长度是奇数
        //当q=p+1时，此时回文中心时两个字符，回文串长度是偶数
        int len = str.length;
        int i = left;
        int j = right;
        while(i >= 0 && j < len) {
            if(str[i] == str[j]) {
                i--;j++;
            }else {
                break;
            }
        }
        //j和i之间的子串是回文子串，j和i指向的字符不属于该子串
        return j-i-1;
    }

}
