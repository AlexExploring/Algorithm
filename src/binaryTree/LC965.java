package binaryTree;

/**
 * 单值二叉树
 */
public class LC965 {

    /**
     * 可以遍历二叉树并将二叉树节点的值存入到一个set集合中，最后根据set的大小来判断
     * 二叉树是否为单值二叉树
     */

    public boolean isUnivalTree(TreeNode root) {
        if (root==null)
            return true;
        //如果左节点不为空，并且左节点的值和root节点的值不相等
        if ((root.left!=null&&root.left.val!=root.val)||(root.right!=null&&root.right.val!=root.val))
            return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}