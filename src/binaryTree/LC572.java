package binaryTree;

/**
 *另一颗树的子树
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树
 */

public class LC572 {
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root1==null||root2==null)
            return false;
        if (isSameTree(root1, root2))  //递归遍历root1 并以遍历到的节点去检验是否和root2是相同的树
            return true;
        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;
        else return p!=null && q!=null && p.val == q.val && (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right));
    }
}
