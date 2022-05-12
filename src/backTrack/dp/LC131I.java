package backTrack.dp;

import java.util.ArrayList;
import java.util.List;

public class LC131I {

    int[][] f;
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> tans = new ArrayList<String>();
    int len;

    /**
     * 方法二：回溯 + 记忆化搜索
     */
    public List<List<String>> partition(String s) {
        len = s.length();
        f = new int[len][len];

        dfs(s, 0);
        return ans;
    }

    public void dfs(String s, int i) {
        if (i == len) {
            ans.add(new ArrayList<String>(tans));
            return;
        }
        for (int j = i; j < len; ++j) {
            if (isPalindrome(s, i, j) == 1) {
                tans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                tans.remove(tans.size() - 1);
            }
        }
    }

    /**
     * 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
     */
    public int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }

        // i >= j产生的条件：1.dfs中调用的时候
        // 2.不停的递归isPalindrome(s, i + 1, j - 1);说明了dfs第一次调用isisPalindrome
        // 的时候，i->j 是回文字符串
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }
}