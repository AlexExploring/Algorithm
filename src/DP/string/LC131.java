package DP.string;

import java.util.ArrayList;
import java.util.List;

/**
 * �ָ�����ַ��� �������Ŀ LC132 �ָ���Ĵ�II��
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
        
        // �߽�1: �Խ��ߣ��������ַ������ǻ���
        for(int i = 0; i < len; i++){
            f[i][i] = true;
        }
        // �߽�2:�Խ����ϲ����б�ߣ��������ַ����ж��Ƿ���ȣ������Ϊ����
        for(int i = 0; i < len - 1; i++){
            f[i][i + 1] = s.charAt(i) == s.charAt(i+ 1);
        }
        // ���µ��ϣ��߽�1�ͱ߽�2ȷ��������б�ߣ�����ֻ��Ҫ�ӵ��������п�ʼ���ϲ�ȫ��������
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
