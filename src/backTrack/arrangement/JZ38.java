package backTrack.arrangement;

import java.util.*;

public class JZ38 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new JZ38().permutation1("cba")));
    }

    /**
     * 方法一：回溯+剪枝
     * 将字符串转化为字符串，然后排序，方便去重
     */
    public String[] permutation(String s) {
        //数据预处理
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

        //每一个for确定一个位置，这一个位置有len中可能
        for (int i = 0; i < len; i++) {
            //我们保证，第i个位置需要一个数，
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
     * 方法二：思路参见LC31:下一个排列，不断的生成下一个序列即可
     */
    public String[] permutation1(String s) {
        List<String> ans = new ArrayList<String>();
        //为了正确的生成所有排列，必须向排序
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        //不断调用nextPermutation()生成下一个排列即可
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
        //i < 0说明不存在下一个排列了
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
