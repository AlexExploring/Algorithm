package DP.LC_12_23_0_zxl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhxspacex
 * @date 2020/12/23 10:57
 *
 * 俄罗斯信封套娃
 */
public class LC354 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [][] envelopes = {{5,4},{6,4},{6,7},{2,3}};

    }

    public static int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len < 1) return 0;
        int max = 1;
        int [] dp = new int[len];
        Arrays.fill(dp,1);
        //Arrays.sort(envelopes, new Comparator<int[]>() {
        // @Override
        //    public int compare(int[] envelope1, int[] envelope2) {
        //          if (envelope1[0] != envelope2[0]) {
        //                 return envelope1[0] - envelope2[0];
        //           }
        //                return envelope2[1] - envelope1[1];
        //            }
        //        });
        Arrays.sort(envelopes,(a,b) -> (a[0]-b[0]));
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static int maxEnvelopes1(int[][] envelopes){
        int maxL = 0;
        int[] dp = new int[envelopes.length];
        //如果长度相等，按照宽度降序排列，否则按照长度升序排列
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]));

        for(int[] env : envelopes) {
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = lo+(hi-lo)/2;
                if(dp[mid] < env[1])
                    lo = mid+1;
                else
                    hi = mid;
            }
            dp[lo] = env[1];
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }
}
