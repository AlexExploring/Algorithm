package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * �ָ�����ַ���
 *
 * ��JZ86��ͬ
 */
public class LC131 {

    boolean[][] f;
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> tans = new ArrayList<String>();
    int len;

    /**
     * ���� + ��̬�滮Ԥ����
     */
    public List<List<String>> partition(String s) {
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
