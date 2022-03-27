package tx50;

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
        //左右子树都为空，则返回null
        if(left == null || right == null) return null;
        if(left == null) return right;
        if(right == null) return left;
        //左右子树都找到p或q了，那就说明p和q分别在左右两个子树上，所以此时的最近公共祖先就是root
        return root;
    }



    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();
    /**
     * 存储所有节点的父节点
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //先获得除根节点之外所有节点的父节点
        dfs(root);

        //使用visited存储root到p的路径
        while (p!=null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        while (q!=null) {
            //获得q的路径的同时判断是否和p的路径有重合点
            if (visited.contains(q.val)) return q;
            q = parent.get(q.val);
        }
        return null;
    }

    /**
     * 使用hashmap存储除了除根节点以外所有节点的父节点
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
