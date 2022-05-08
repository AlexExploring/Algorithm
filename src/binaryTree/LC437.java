package binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和III
 *
 * 相似题目；LC112 路径总和 I,LC113 路径总和 II, LC437 路径总和III
 *
 * 题解链接:https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/
 */
public class LC437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int ret = rootSum(root,targetSum);
        ret += pathSum(root.left,targetSum);
        ret += pathSum(root.right,targetSum);

        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) return 0;
        int val = root.val;
        if (targetSum == val) ret++;
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
    /**
     * 定义前缀和为：到达当前元素的路径上，之前所有元素的和
     */
    public int pathSum1(TreeNode root, int targetSum) {
        Map<Integer,Integer> prefix = new HashMap<>();
        //给根结点的“父节点“一个前缀和。 这里的 put(0,1) 的意义是认为根
        // 结点之前的前缀和是 0，这样可以计算以根结点为起点的路径的前缀和。
        prefix.put(0,1);
        return dfs(root,prefix,0,targetSum);
    }

    public int dfs(TreeNode root, Map<Integer,Integer> prefix, int cur, int targetSum) {
        if (root == null) return 0;
        int ret = 0;
        cur += root.val;

        ret += prefix.getOrDefault(cur-targetSum,0);
        //记录给下一层级的点使用的前缀和
        prefix.put(cur,prefix.getOrDefault(cur,0)+1);
        ret += dfs(root.left,prefix,cur,targetSum);
        ret += dfs(root.right,prefix,cur,targetSum);
        //去除当前链路产生的前缀和，避免对后续链路造成影响
        prefix.put(cur,prefix.getOrDefault(cur,0)-1);

        return ret;
    }


}