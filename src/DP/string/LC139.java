package DP.string;

import java.util.HashSet;
import java.util.List;

/**
 *  ���ʲ��  ��̬�滮
 *
 * ����һ���ַ��� s ��һ���ַ����б� wordDict ��Ϊ�ֵ䡣�����ж��Ƿ���������ֵ��г��ֵĵ���ƴ�ӳ� s ��(���������ǣ�
 * ����һ���ǿ��ַ��� s ��һ�������ǿյ��ʵ��б� wordDict���ж� s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�)
 *
 */
public class LC139 {

    /**
     * dp[i] ��ʾ�ַ��� s ǰ i ���ַ���ɵ��ַ��� s[0..i-1]�Ƿ��ܱ��ո��ֳ����ɸ��ֵ��г��ֵĵ��ʡ�
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        //�߽磬���ַ���
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // ���dp[j]Ϊtrue,��ʾs[0..j-1]���Ա����Ϊ���ɸ��ֵ��г��ֵĴ�
                //���ڽ�ȡ�ַ�����ʱ��s.substring(j,i);
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}