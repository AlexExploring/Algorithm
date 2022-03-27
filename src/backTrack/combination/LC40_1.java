package backTrack.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhxspacex
 * @date 2021/1/13 16:16
 */
public class LC40_1 {
    public static void main(String[] args) {
        LC40_1 a = new LC40_1();
        int [] can = {2,5,2,1,2};
        int target = 5;
        System.out.println(a.combinationSum2(can,target));
    }
    /**
     *官方题解
     */
    List<int[]> freq = new ArrayList<int[]>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> sequence = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        for (int i = 0; i < freq.size(); i++) {
            System.out.println(Arrays.toString(freq.get(i)));
        }
        dfs(0, target);
        return ans;
    }

    public void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }
}
