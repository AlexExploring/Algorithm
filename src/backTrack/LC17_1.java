package backTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhxspacex
 * @date 2021/1/11 20:38
 */

/**
 * 对t使用StringBuffer，对Lc17进行了一个优化
 */
public class LC17_1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        LC17 a = new LC17();
        System.out.println(a.letterCombinations(scan.nextLine()));
    }

    HashMap<Integer,String> map = new HashMap<>();
    List<String> ans = new ArrayList();
    StringBuffer t = new StringBuffer();
    String [] data = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len==0) return ans;
        initMap();
        char [] t = digits.toCharArray();
        String [] des = new String[len];
        for (int i = 0; i < len; i++) {
            des[i] = map.get(t[i]-'0');
        }
        backTrack(des,len,0);
        return ans;
    }

    public void backTrack(String [] des,int len,int now){
        if (now == len){
            ans.add(new String(t));
        }else {
            for (int i = 0; i < des[now].length(); i++) {
                t.append(des[now].charAt(i));
                backTrack(des,len,now+1);
                t.deleteCharAt(t.length()-1);
            }
        }
    }

    public void initMap(){
        for (int i = 2; i <= 9; i++) {
            map.put(i,data[i-2]);
        }
    }
}
