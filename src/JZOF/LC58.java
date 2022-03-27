package JZOF;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *��ת����˳��
 *
 * "" �� �� ���ǲ�һ����
 * ǰ���ǿ��ַ��������ߺ���һ���ո�
 *
 * �Կո�Ϊ�ָ������ַ����ָ���������ʼ��� x > 1���ո�
 * ���ڵ����б� strs�У��������ʼ���� x - 1�� ���յ��ʡ� ���� "" ��
 *
 */
public class LC58 {
    public static void main(String[] args) {
        System.out.println(reverseWords2("a good   example"));
    }

    public static String reverseWords(String s) {
        //�����ַ���
        s = s.trim();
        StringBuffer data = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                while (s.charAt(i+1)==' '){
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
     *˫ָ�� �������
     */
    public static String reverseWords1(String s) {
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

    public static String reverseWords2(String s) {
        String[] strs = s.trim().split(" "); // ɾ����β�ո񣬷ָ��ַ���
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // ������������б�
            if(strs[i].equals("")) continue; // �����յ���������
            res.append(strs[i] + " "); // ������ƴ���� StringBuilder
        }
        return res.toString().trim(); // ת��Ϊ�ַ�����ɾ��β���ո񣬲�����
    }

    public String reverseWords3(String s) {
        // ��ȥ��ͷ��ĩβ�Ŀհ��ַ�
        s = s.trim();
        // ����ƥ�������Ŀհ��ַ���Ϊ�ָ����ָ�
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
