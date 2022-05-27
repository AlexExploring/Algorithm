package String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ��ת����˳��
 *
 * "" �� �� ���ǲ�һ����
 * ǰ���ǿ��ַ��������ߺ���һ���ո�
 *
 * �Կո�Ϊ�ָ������ַ����ָ���������ʼ��� x > 1���ո�
 * ���ڵ����б� strs�У��������ʼ���� x - 1�� ���յ��ʡ� ���� "" ��
 *
 * ��JZ58I��ͬ
 */
public class LC151 {

    /**
     * ������Ϊ���飬�������
     */
    public String reverseWords(String s) {
        //�����ַ���
        s = s.trim();
        //ת��Ϊ���飬���������  ��\\s+�� ƥ�����ո�
        String [] res = s.split("\\s+");
        StringBuffer ans = new StringBuffer();
        for (int i = res.length-1; i >= 0; i--) {
            ans.append(res[i]);
            if (i != 0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    public String reverseWords1(String s) {
        // ��ȥ��ͷ��ĩβ�Ŀհ��ַ�
        s = s.trim();
        // ����ƥ�������Ŀհ��ַ���Ϊ�ָ����ָ�
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static String reverseWords2(String s) {
        //�����ַ���
        s = s.trim();
        StringBuffer data = new StringBuffer();
        //�Լ�ʵ�֣�ȷ������֮��ֻ��һ���ո�
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                //ȷ������֮��ֻ��һ���ո�
                while (s.charAt(i+1) == ' '){
                    i++;
                }
            }
            data.append(s.charAt(i));
        }

        //ת��Ϊ���飬���������
        String [] res = data.toString().split(" ");
        StringBuffer ans = new StringBuffer();
        for (int i = res.length-1; i >= 0; i--) {
            ans.append(res[i]);
            if (i!=0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    /**
     *  ˫ָ�� �Ӻ���ǰ�������������
     */
    public static String reverseWords3(String s) {
        s = s.trim(); // ɾ����β�ո�
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // �����׸��ո�
            res.append(s.substring(i + 1, j + 1) + " "); // ��ӵ���
            while(i >= 0 && s.charAt(i) == ' ') i--; // �������ʼ�ո�
            j = i; // j ָ���¸����ʵ�β�ַ�
        }
        return res.toString().trim(); // ת��Ϊ�ַ���������
    }
}
