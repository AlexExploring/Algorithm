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
     * 时间复杂度：O((2^2n)*n)
     * 空间复杂度：O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        generateAll(new char[2 * n], 0, ans);
        return ans;
    }

    /**
     * 递归生成括号组合,每一个位置有两种可能
     *
     * 在每次身生成完毕后，再判断是否有效，其实生成了很多明显无效的字符串，效率较低
     */
    public void generateAll(char[] current, int pos, List<String> ans) {
        if (pos == current.length) {
            if (isValid(current)) {
                ans.add(new String(current));
            }
            return;
        }

        //同一个位置只有两种可能 要么为(,要么为)
        current[pos] = '(';
        generateAll(current,pos+1,ans);
        current[pos] = ')';
        generateAll(current,pos+1,ans);
    }

    /**
     * 判断生成的括号组合是否有效
     *
     * 由于只有一种括号 () ，所以可以采用双指针快速判断是否有效
     */
    public boolean isValid(char[] current) {
        int balance = 0;
        for (char c : current) {
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
     * 当左括号的数量小于max就可以添加左括号，右括号的数量小于left(左括号的数量)就可以添加右括号
     */
    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int left, int right, int max) {
        //下面的括号添加规则确保了当cur.length() == max * 2的时候，cur一定是有效的
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        //左括号的数量小于max就可以添加左括号
        if (left < max) {
            cur.append('(');
            backtrack(ans, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        //右括号的数量小于left(左括号的数量)就可以添加右括号
        if (right < left) {
            cur.append(')');
            backtrack(ans, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}