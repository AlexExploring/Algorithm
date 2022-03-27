package JZOF.backTrack;

import java.util.*;

public class JZ38 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("aab")));
    }

    /**
     * ����1
     *
     * ����2 ֱ��ʹ��HashSet�������أ�����Ҫ��������Ҳ����Ҫ�������ж�����
     */
    public static String[] permutation(String s) {

        char [] temp = s.toCharArray();
        Arrays.sort(temp);
        StringBuffer rea = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            rea.append(temp[i]);
        }

        int [] book = new int[s.length()];

        backTrack(rea.length(),rea.toString(),book);

        return ans.toArray(new String[ans.size()]);
    }

    static List<String> ans = new ArrayList<>();
    static StringBuffer tans = new StringBuffer();

    public static void backTrack(int len,String rea,int [] book){
        if (tans.length()==len){
            ans.add(tans.toString());
            return;
        }

        for (int i = 0; i < len; i++) { //ÿһ��forȷ��һ��λ�ã���һ��λ����len�п���
            //���Ǳ�֤����i��λ����Ҫһ������
            if (book[i]==1||(i>0&&rea.charAt(i)==rea.charAt(i-1)&&book[i-1]==0)){
                continue;
            }

            book[i]=1;
            tans.append(rea.charAt(i));
            backTrack(len,rea,book);
            tans.deleteCharAt(tans.length()-1);
            book[i]=0;
        }
    }
}