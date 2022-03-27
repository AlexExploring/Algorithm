package String;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LC5_3 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\ZhangHaixia\\IdeaProjects\\Suanfa\\src\\dongtaiguihua\\LC5_SJ");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String s = br.readLine();

        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            count += isOk(str, i, i); //奇数
            count += isOk(str, i, i+1); //偶数
        }
        return count;

    }

    public static int isOk(char[] str,int p,int q) {
        //当p=q的时候，回文中心是一个字符，回文串的长度是奇数
        //当q=p+1时，此时回文中心时两个字符，回文串长度是偶数
        int n = str.length;
        int re = 0;
        while(p >= 0 && q < n) {
            if(str[p] == str[q]) {
                p--;q++;
                re++;
            }else {
                break;
            }
        }
        return re;
    }
}
