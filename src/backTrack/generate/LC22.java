package backTrack.generate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhxspacex
 * @date 2021/1/12 20:38
 */
public class LC22 {

    /**
     * 暴力法 枚举所有可能的字符串，判断是否有效，然后加入结果。
     * 为了生成所有序列，我们可以使用递归。
     *
     * 时间复杂度：O(2^2n*n)
     * 空间复杂度：O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    /**
     * 递归生成括号组合,每一个位置有两种可能
     */
    public void generateAll(char[] current, int pos, List<String> ans) {
        if (pos == current.length) {
            if (valid(current)) {
                ans.add(new String(current));
            }
            return;
        }

        current[pos] = '(';
        generateAll(current, pos + 1, ans);
        current[pos] = ')';
        generateAll(current, pos + 1, ans);
    }

    /**
     * 判断生成的括号组合是否有效
     */
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
     * 回溯法  在生成字符串过程中采用模式匹配确保得到的是有效字符串
     *
     * 我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到保证加入的字符串有效，
     */
    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        // left < right 必然不合法
        if (left < right) return;

        if (left < max) {
            cur.append('(');
            backtrack(ans, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (right < max) {
            cur.append(')');
            backtrack(ans, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    /**
     * 在生成字符串过程中采用模式匹配确保得到的是有效字符串
     */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack2(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack2(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack2(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public List<String> generateParenthesis3(int n) {
        return generate(n);
    }

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


}
