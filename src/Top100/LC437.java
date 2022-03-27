package Top100;

import java.util.HashMap;
import java.util.Map;

public class LC437 {

    /**
     * 对于每一个节点，求以该节点为起点的路径数目
     */
    public int pathSum1(TreeNode root, int targetSum) {
        if (root==null) return 0;

        int ret = rootSum(root,targetSum);
        ret += pathSum1(root.left,targetSum);
        ret += pathSum1(root.right,targetSum);
        return ret;
    }

    public int rootSum(TreeNode root,int targetSum) {
        int ret = 0;
        if (root==null) return 0;
        int val = root.val;
        if (val==targetSum) ret++;
        ret += rootSum(root.left,targetSum-val);
        ret += rootSum(root.right,targetSum-val);
        return ret;
    }

    /**
     * 定义前缀和为：由根节点到当前节点的路径上所有节点的和。我们利用先序遍
     * 历二叉树，记录下根节点 root 到当前节点 p 的路径上除当前节点以外所
     * 有节点的前缀和，在已保存的路径前缀和中查找是否存在前缀和刚好等于当
     * 前节点到根节点的前缀和 curr 减去 targetSum。
     */
    public int pathSum(TreeNode root,int targetSum) {
        Map<Integer,Integer> prefix = new HashMap<>();
        //给根结点的“父节点“一个前缀和。 这里的 put(0,1) 的意义是认为根
        // 结点之前的前缀和是 0，这样可以计算以根结点为起点的路径的前缀和。
        prefix.put(0,1);
        return dfs(root,prefix,0,targetSum);
    }

    public int dfs(TreeNode root,Map<Integer,Integer> prefix,int cur,int targetSum) {
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
