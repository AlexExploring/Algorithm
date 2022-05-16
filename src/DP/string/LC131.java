package DP.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文字符串 （相关题目 LC132 分割回文串II）
 */
public class LC131 {

    boolean[][] f;
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> tans = new ArrayList<String>();
    int len;

    /**
     * 回溯 + 动态规划预处理
     */
    public List<List<String>> partition(String s) {
        len = s.length();
        f = new boolean[len][len];
        
        // 边界1: 对角线，即单个字符，都是回文
        for(int i = 0; i < len; i++){
            f[i][i] = true;
        }
        // 边界2:对角线上侧紧邻斜线，即两个字符，判断是否相等，相等则为回文
        for(int i = 0; i < len - 1; i++){
            f[i][i + 1] = s.charAt(i) == s.charAt(i+ 1);
        }
        // 从下到上，边界1和边界2确定了两条斜线，所以只需要从倒数第三行开始往上补全右上三角
        for(int i = len - 3; i >= 0; i--){
            for(int j = i + 2; j < len; j++){
                f[i][j] = f[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }
        dfs(s, 0);
        return ans;
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
}
