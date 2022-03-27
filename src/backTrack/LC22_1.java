package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhxspacex
 * @date 2021/1/12 20:38
 */
public class LC22_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LC22_1 a = new LC22_1();
        System.out.println(a.generateParenthesis1(scan.nextInt()));
    }
    /**
     *暴力法 枚举所有可能的字符串，判断是否有效，然后加入结果。
     *
     * 为了生成所有序列，我们可以使用递归。长度为 n 的序列就是在长度为 n-1 的序列前加一个 '(' 或 ')'。
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                System.out.println("有效：加入"+Arrays.toString(current));
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            System.out.println("pos="+pos+" "+"加入+"+"(");
            System.out.println("此时current"+Arrays.toString(current));
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            System.out.println("pos="+pos+" "+"加入+"+")");
            System.out.println("此时current"+Arrays.toString(current));
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    /**
     *回溯法  在生成字符串过程中采用模式匹配确保得到的是有效字符串
     *
     * 我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到保证加入的字符串有效，
     */
    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            System.out.println("有效:"+cur);
            return;
        }
        if (open < max) {
            cur.append('(');
            System.out.println("open="+open+" "+"close="+close+" "+"加入+"+"("+"cur:"+cur);
            backtrack(ans, cur, open + 1, close, max);
            System.out.println("open="+open+" "+"close="+close+" "+"删除+"+"("+"cur:"+cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            System.out.println("open="+open+" "+"close="+close+" "+"加入+"+")"+"cur:"+cur);
            backtrack(ans, cur, open, close + 1, max);
            System.out.println("open="+open+" "+"close="+close+" "+"删除+"+")"+"cur:"+cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    /**
     *
     */
    ArrayList[] cache = new ArrayList[100];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generate(c)) {
                    for (String right: generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis2(int n) {
        return generate(n);
    }
}
