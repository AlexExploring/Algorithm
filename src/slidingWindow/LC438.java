package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * �ҵ��ַ�����������ĸ��λ��
 * LC49 ��ĸ��λ�ʷ��� ��ֻ����Сд��ĸ��
 * ��LC567 ����
 */
public class LC438 {

    /**
     * �������ڣ�ֻ��Ҫ��֤�����ڸ����ַ���������ͬ����֤����һ����ĸ��λ��
     * ���ڲ������ƣ�
     *
     * ans�д洢����ÿ����ĸ��λ�ʵ���ʼ�±�
     */
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        //��ʼ������
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = pLen; i < sLen; ++i) {
            //�Ƴ���������ߵ�Ԫ��
            --sCount[s.charAt(i-pLen) - 'a'];
            //�򴰿�����ӵ�ǰԪ��
            ++sCount[s.charAt(i) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i-pLen+1);
            }
        }

        return ans;
    }

    /**
     * ���������Ż������淽���У�ÿ�ζ������ַ�������бȽϣ��ܺ�ʱ��
     */
    public List<Integer> findAnagrams1(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        //��һ��diff����¼�������ַ�������ͬ�ĸ���
        int diff = 0;
        for (int j = 0; j < 26; ++j) {
            //��������ĸ count[j] ��������ͬ
            if (count[j] != 0) {
                ++diff;
            }
        }

        if (diff == 0) {
            ans.add(0);
        }

        for (int i = pLen; i < sLen; i++) {
            int x = s.charAt(i)-'a',y = s.charAt(i-pLen)-'a';

            if (x != y) {
                //�򴰿��Ҳ����Ԫ��
                // �޸�֮ǰ����x�����ַ���ȣ���diff+1
                if (count[x] == 0) diff++;
                count[x]++;
                // �޸�֮������x�����ַ���ȣ���diff-1
                if (count[x] == 0) diff--;

                //�Ƴ���������ߵ�Ԫ��
                if (count[y] == 0) diff++;
                count[y]--;
                if (count[y] == 0) diff--;
            }

            if (diff == 0) ans.add(i-pLen+1);

        }

        return ans;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        int len1 = p.length(), len2 = s.length();
        List<Integer> ans = new ArrayList<>();
        if (len1 > len2) return ans;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[p.charAt(i) - 'a']--;
        }

        int left = 0;
        for (int right = 0; right < len2; right++) {
            int x = s.charAt(right) - 'a';
            count[x]++;
            while (count[x] > 0) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == len1) ans.add(left);
        }

        return ans;
    }
}
