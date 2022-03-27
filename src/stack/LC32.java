package stack;

/**
 *最长有效括号
 */

import java.util.Scanner;
import java.util.Stack;
public class LC32 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(maxString1(s));
    }

    //该方法是Leecode20 的简化版本 只针对‘（’和‘）’，两者必须以正确的顺序匹配即：‘（’‘）’
    //时间复杂度O(N),空间复杂度O(N)
    public static boolean isValid(String s){
        if (s == null || s.length() < 1)
            return false;
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(c);
            }else {
                if (stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        if (stack.isEmpty())
            return true;

        return false;
    }

    //优化版本，时间复杂度O(N),空间复杂度O(1)
    public static boolean isValid1(String s){
        if (s == null || s.length() < 1)
            return false;
        int n = s.length();
        int i = 0;
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

    // LC32
    //一个只包含'('和')'的字符串，找出最长的包含有小括号的子串的长度
    public static int maxString(String s){
        int max = 0,temp = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')')
                continue;
            for (int j = i; j < n; j++) {
                String s1 = s.substring(i,j+1);
                if(isValid1(s1) == true){
                    temp = j-i+1;
                }
                if (temp > max){
                    max = temp;temp = 0;
                }
            }
        }
        return max;
    }

    //优化 时间复杂度O(N)，空间复杂度O(N)
    public static int maxString1(String s){
        //最开始的-1表示最长子串只能从0开始
        int max = 0,n = s.length();

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                }else {
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

    //优化 时间复杂度O（N），空间复杂度O（1）
    public static int maxString2(String s){
        if (s == null || s.length() < 1)
            return 0;
        int left = 0,right = 0,max =0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else right++;

            if (left == right)
                max = Math.max(max,2*right);
            else if(right > left){
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else right++;

            if (left == right)
                max = Math.max(max,2*left);
            else if(left > right){
                left = right = 0;
            }
        }
        return max;
    }

    //https://leetcode-cn.com/problems/longest-valid-parentheses
    // /solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
    //动态规划  时间复杂度O(n),空间复杂度O（N）
    public static int maxString3(String s){
        int max = 0;
        int [] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')'){
                if (s.charAt(i-1) == '('){
                    dp[i] = (i > 2 ? dp[i-2] : 0 +2);
                }else if (i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] + ((i-dp[i-1]) >= 2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

}
