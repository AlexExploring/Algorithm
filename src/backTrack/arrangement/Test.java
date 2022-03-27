package backTrack.arrangement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        int [] book = new int[n];
        Test test = new Test();
        test.backTrack(book,nums,m);
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    public void backTrack(int [] book,int [] nums,int m){
        if (tans.size()==m){
            ans.add(new ArrayList<>(tans));
            System.out.println(tans);
        }
        for (int i = 0; i < nums.length; i++) {
            if (book[i]==0){
                //nums[i]<tans.get(tans.size()-1)保证结果是有序的，就可以避免重复计算
                if (tans.size()>0&&nums[i]<tans.get(tans.size()-1)) continue;
                //和3基本上一样
                book[i]=1;
                tans.add(nums[i]);
                backTrack(book,nums,m);
                book[i]=0;
                tans.remove(tans.size()-1);
            }else continue;
        }
    }
}
