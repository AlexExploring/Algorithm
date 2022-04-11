package JZOFII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最少回文分割 （和LC132相同：分割回文串2）
 */
public class JZ94 {

    boolean[][] f;
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> tans = new ArrayList<String>();
    int len;

    /**
     * 方法一：暴力枚举出所有子字符串都为回文字符串的所有情况，并计算分割次数
     * <p>
     * 结果：超出内存限制
     */
    public int minCut(String s) {
        len = s.length();
        f = new boolean[len][len];

        for (int i = 0; i < len; ++i) {
            Arrays.fill(f[i], true);
        }
        //动态规划预处理判断 i~j (包括i和j)是否为回文字符串
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);

        int min = Integer.MAX_VALUE;
        for (List<String> list : ans) {
            min = Math.min(min, list.size() - 1);
        }
        return min;
    }

    public void dfs(String s, int i) {
        if (i == len) {
            ans.add(new ArrayList<String>(tans));
            return;
        }
        for (int j = i; j < len; j++) {
            if (f[i][j]) {
                tans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                tans.remove(tans.size() - 1);
            }
        }
    }

    /**
     * 方法二：预处理+动态规划
     *
     */
    public int minCut1(String s) {
        int len = s.length();
        boolean[][] f = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(f[i], true);
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }

        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            if (f[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (f[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[len-1];
    }
}
