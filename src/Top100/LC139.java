package Top100;

import java.util.HashSet;
import java.util.List;

/**
 *  ���ʲ��  ��̬�滮
 *
 *  ����һ���ǿ��ַ��� s ��һ�������ǿյ��ʵ��б� wordDict���ж� s �Ƿ���Ա��ո���Ϊһ���������ֵ��г��ֵĵ��ʡ�
 */
public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> strings = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // j����ȡ���� iȡ����
                if (dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

