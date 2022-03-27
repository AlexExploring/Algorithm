package JZOF;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *翻转单词顺序
 *
 * "" 和 “ ”是不一样的
 * 前者是空字符串，后者含有一个空格
 *
 * 以空格为分割符完成字符串分割后，若两单词间有 x > 1个空格，
 * 则在单词列表 strs中，此两单词间会多出 x - 1个 “空单词” （即 "" ）
 *
 */
public class LC58 {
    public static void main(String[] args) {
        System.out.println(reverseWords2("a good   example"));
    }

    public static String reverseWords(String s) {
        //处理字符串
        s = s.trim();
        StringBuffer data = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                while (s.charAt(i+1)==' '){
                    i++;
                }
            }
            data.append(s.charAt(i));
        }

        //转化为数组，并逆序添加
        String [] res = data.toString().split(" ");
        StringBuffer ans = new StringBuffer();
        for (int i = res.length-1; i >= 0; i--) {
            ans.append(res[i]);
            if (i!=0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    /**
     *双指针 依次添加
     */
    public static String reverseWords1(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }

    public static String reverseWords2(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }

    public String reverseWords3(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
