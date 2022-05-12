package backTrack.dp;

import java.util.ArrayList;
import java.util.List;

public class LC131I {

    int[][] f;
    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> tans = new ArrayList<String>();
    int len;

    /**
     * ������������ + ���仯����
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
     * ���仯�����У�f[i][j] = 0 ��ʾδ������1 ��ʾ�ǻ��Ĵ���-1 ��ʾ���ǻ��Ĵ�
     */
    public int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }

        // i >= j������������1.dfs�е��õ�ʱ��
        // 2.��ͣ�ĵݹ�isPalindrome(s, i + 1, j - 1);˵����dfs��һ�ε���isisPalindrome
        // ��ʱ��i->j �ǻ����ַ���
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