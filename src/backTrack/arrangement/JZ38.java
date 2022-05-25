package backTrack.arrangement;

import java.util.*;

public class JZ38 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new JZ38().permutation1("cba")));
    }

    /**
     * ����һ������+��֦
     * ���ַ���ת��Ϊ�ַ�����Ȼ�����򣬷���ȥ��
     */
    public String[] permutation(String s) {
        //����Ԥ����
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
        if (tans.length() == len){
            ans.add(tans.toString());
            return;
        }

        //ÿһ��forȷ��һ��λ�ã���һ��λ����len�п���
        for (int i = 0; i < len; i++) {
            //���Ǳ�֤����i��λ����Ҫһ������
            if (book[i] == 1 || (i > 0 && rea.charAt(i) == rea.charAt(i-1) && book[i-1] == 0)){
                continue;
            }

            book[i]=1;
            tans.append(rea.charAt(i));
            backTrack(len,rea,book);
            tans.deleteCharAt(tans.length()-1);
            book[i]=0;
        }
    }

    /**
     * ��������˼·�μ�LC31:��һ�����У����ϵ�������һ�����м���
     */
    public String[] permutation1(String s) {
        List<String> ans = new ArrayList<String>();
        //Ϊ����ȷ�������������У�����������
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        //���ϵ���nextPermutation()������һ�����м���
        do {
            ans.add(new String(arr));
        } while (nextPermutation(arr));

        return ans.toArray(new String[ans.size()]);
    }

    public boolean nextPermutation(char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        //i < 0˵����������һ��������
        if (i < 0) {
            return false;
        }
        int j = arr.length - 1;
        while (j >= 0 && arr[i] >= arr[j]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i + 1);
        return true;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(char[] arr, int start) {
        int left = start, right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}
