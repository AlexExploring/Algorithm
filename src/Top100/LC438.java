package Top100;

import java.lang.reflect.Array;
import java.util.*;

/**
 * �ҵ��ַ�����������ĸ����λ��
 */
public class LC438 {

    /**
     * �����ⷨ
     */
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        char[] charsp = p.toCharArray();
        Arrays.sort(charsp);

        for (int i = 0; i < s.length(); i++) {
            if (p.length()+i<=s.length()){

                String sub = s.substring(i, p.length() + i);
                char[] charssub = sub.toCharArray();
                Arrays.sort(charssub);

                int flag = 0;
                for (int j = 0; j < p.length(); j++) {
                    if (charsp[j]!=charssub[j]) {
                        flag = 1;break;
                    }
                }

                if (flag==0) res.add(i);
            }
        }

        return res;
    }


    /**
     * �������� + ����
     *
     * �����ַ����ĳ�������� �����ַ����и����ַ����ֵĴ������ �� Ϊ ��λ��
     */
    public List<Integer> findAnagrams1(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if(n < m) return res;
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for(int i = 0; i < m; i++){
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sCnt, pCnt)){
            res.add(0);
        }
        for(int i = m; i < n; i++){
            sCnt[s.charAt(i - m) - 'a']--;
            sCnt[s.charAt(i) - 'a']++;
            if(Arrays.equals(sCnt, pCnt)){
                res.add(i - m + 1);
            }
        }
        return res;
    }

    /**
     * �������ڼ�˫ָ˫ָ��
     */
    public List<Integer> findAnagrams2(String s, String p) {
        return null;
    }
}
