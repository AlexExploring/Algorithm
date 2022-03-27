package JZOFII;

import java.util.HashMap;
import java.util.Map;

/**
 * 向下的路径节点之和
 *
 */
public class JZ50 {

    /**
     * 题目如果要求必须是从root节点开始的，那就是简单题了，直接一个深度优先遍历就可以找出所有路劲
     *
     * 现在问题是要求路径不需要从根节点开始，可以是任意节点，要怎么办？当然是尝试从每颗子树开始了。
     */
    public int pathSum1(TreeNode root, int targetSum) {
        if (root==null) return 0;

        int ret = rootSum(root,targetSum);
        ret += pathSum1(root.left,targetSum);
        ret += pathSum1(root.right,targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root==null) return 0;
        int val = root.val;
        if (val==targetSum) ret++;
        ret += rootSum(root.left,targetSum-val);
        ret += rootSum(root.right,targetSum-val);
        return ret;
    }


    /**
     * 定义前缀和为：由根节点到当前节点的路径上所有节点的和.
     */
    public int pathSum(TreeNode root, int targetSum) {
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
        prefix.put(cur,prefix.getOrDefault(cur,0)+1);
        ret += dfs(root.left,prefix,cur,targetSum);
        ret += dfs(root.right,prefix,cur,targetSum);
        prefix.put(cur,prefix.getOrDefault(cur,0)-1);

        return ret;
    }
}
