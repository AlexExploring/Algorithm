package binaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树的最近公共祖先
 *
 * 题目描述：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 题目要求：1.所有节点的值都是唯一的。2.p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 和LC235类似
 */
public class LC236 {

    /**
     * 实际上就是对递归先序遍历二叉树进行了一些额外的处理
     */
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



    /**
     * 首先遍历树，使用map存储所有节点值的父节点
     *
     * 注意数据范围：
     * 树中节点数目在范围 [2, 105] 内。
     * -109 <= Node.val <= 109
     * 所有 Node.val 互不相同 。
     * p != q
     * p 和 q 均存在于给定的二叉树中。
     *
     */

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        //先获得除根节点之外所有节点的父节点
        dfs(root);

        //使用visited存储root到p的路径
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }

        while (q != null) {
            //获得q的路径的同时判断是否和p的路径有重合点，有重合点说明，重合点就是最最近的公共祖先
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
