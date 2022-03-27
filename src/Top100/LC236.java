package Top100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树的最近公共祖先
 *
 * 题目描述：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class LC236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    /**
     * 存储所有节点的父节点
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p!=null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        while (q!=null) {
            if (visited.contains(q.val)) return q;
            q = parent.get(q.val);
        }
        return null;
    }

    /**
     * 遍历存储除了根节点以外所有节点的父节点
     */
    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }
}
