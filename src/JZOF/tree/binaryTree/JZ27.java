package JZOF.tree.binaryTree;

/**
 * 二叉树的镜像
 *
 * 输入一个二叉树 ，并输出该二叉树的镜像
 */
public class JZ27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null) return null;

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
