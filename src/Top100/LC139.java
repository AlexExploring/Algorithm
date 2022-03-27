package Top100;

import java.util.HashSet;
import java.util.List;

/**
 *  单词拆分  动态规划
 *
 *  给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 */
public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> strings = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // j可以取到， i取不到
                if (dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

