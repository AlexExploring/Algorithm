package binaryTree;

/**
 * 平衡二叉树
 */
public class LC110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;  // 树为空的话不可以计算它的高度，直接判断其为平衡二叉树

        //isBalanced(root.left)&&isBalanced(root.right) 递归检查每一个节点的左右子树的高度差
        return (Math.abs(helper(root.left)-helper(root.right))<=1)&&isBalanced(root.left)&&isBalanced(root.right);
    }

    public int helper(TreeNode root) {
        if (root==null) return 0;
        else return Math.max(helper(root.left),helper(root.right))+1;
    }
}
