package backTrack;

import java.util.*;

/**
 * @author zhxspacex
 * @date 2021/1/10 23:02
 */
public class LC17 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        LC17 a = new LC17();
        System.out.println(a.letterCombinations(scan.nextLine()));
    }

    HashMap<Integer,String> map = new HashMap<>();
    List ans = new ArrayList();
    String t = new String();
    String [] data = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits==null){
            return ans;
        }
        int len = digits.length();
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
            ans.add(t);
        }else {
            for (int i = 0; i < des[now].length(); i++) {
                t = t+des[now].charAt(i);
                backTrack(des,len,now+1);
                t = t.substring(0,t.length()-1); //LC17_1使用StringBuffer对这里进行了优化
            }
        }
    }

    public void initMap(){
        for (int i = 2; i <= 9; i++) {
            map.put(i,data[i-2]);
        }
    }
}
