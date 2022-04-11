package JZOFII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���ٻ��ķָ� ����LC132��ͬ���ָ���Ĵ�2��
 */
public class JZ94 {

    boolean[][] f;
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> tans = new ArrayList<String>();
    int len;

    /**
     * ����һ������ö�ٳ��������ַ�����Ϊ�����ַ��������������������ָ����
     * <p>
     * ����������ڴ�����
     */
    public int minCut(String s) {
        len = s.length();
        f = new boolean[len][len];

        for (int i = 0; i < len; ++i) {
            Arrays.fill(f[i], true);
        }
        //��̬�滮Ԥ�����ж� i~j (����i��j)�Ƿ�Ϊ�����ַ���
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
     * ��������Ԥ����+��̬�滮
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
