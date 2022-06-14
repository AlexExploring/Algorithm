package backTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class LC17 {

    public static void main(String[] args) {
        new LC17().letterCombinations("23");
    }

    HashMap<Integer,String> map = new HashMap<>();
    List<String> ans = new ArrayList();
    StringBuffer temp = new StringBuffer();
    String [] data = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0) return ans;

        initMap();
        String [] des = new String[len];
        for (int i = 0; i < len; i++) {
            des[i] = map.get(digits.charAt(i)-'0');
        }

        backTrack(des,len,0);

        return ans;
    }

    public void backTrack(String [] des,int len,int now){
        if (now == len){
            ans.add(new String(temp));
        }else {
            for (int i = 0; i < des[now].length(); i++) {
                temp.append(des[now].charAt(i));
                backTrack(des,len,now+1);
                temp.deleteCharAt(now);
            }
        }
    }

    public void initMap(){
        for (int i = 2; i <= 9; i++) {
            map.put(i,data[i-2]);
        }
    }
}
