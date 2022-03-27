package DP;

import java.util.Scanner;
//加油站  https://leetcode-cn.com/problems/gas-station/
public class LC134 {
    //环形数组法，判断环形数组res,从某个下标开始，顺序遍历，直到遍历结束的时候，能够让数组的连续和一直>=0。
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] gas = {1,2,3,4,5};
        int [] cost = {3,4,5,1,2};

        System.out.println(find(gas,cost));
    }

    public static int find(int [] gas,int [] cost){
        int n = gas.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = gas[i] - cost[i];
        }

        int cap = 0;
        int i = -1;
        for (i = 0; i < n; i++) {
            if (res[i] < 0)
                continue;
            cap=res[i];
            int k = (i+1)%n;
            while (k != i){
                cap+=res[k];
                k = (k+1)%n;
                if (cap < 0){
                    if (i == n-1)
                        return -1;
                    break;
                }
            }

            if (cap >= 0 && k == i)
                return i;
        }

        return -1;
    }
}
