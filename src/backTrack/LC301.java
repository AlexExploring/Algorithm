package backTrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ɾ����Ч������
 */
public class LC301 {

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> curSet = new HashSet<>();

        curSet.add(s);
        while (true) {
            for (String str : curSet) {
                if (isValid(str)) {
                    ans.add(str);
                }
            }

            if (ans.size() > 0) return ans;

            Set<String> nextSet = new HashSet<>();
            for (String str : curSet) {
                for (int i = 0; i < str.length(); i++) {
                    //ȥ��
                    if (i > 0 && str.charAt(i) == str.charAt(i-1)) {
                        continue;
                    }
                    //�����ǰ�ַ�Ϊ ( �� ) �Ļ�������ɾ��
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        nextSet.add(str.substring(0,i)+str.substring(i+1));
                    }
                }
            }
            curSet = nextSet;
        }
    }

    public boolean isValid(String s) {
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            }else if (s.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }

        return cnt == 0;
    }
}
