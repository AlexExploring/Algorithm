package JZOFII;

/**
 * 二叉树剪枝
 */
public class JZ47 {
    public TreeNode pruneTree(TreeNode root) {
        return rec(root) ? root : null;
    }

    /**
     * 判断以root节点为根节点的子树是否包含1
     */
    public boolean rec(TreeNode root) {
        if (root == null) return false;
        boolean left = rec(root.left);
        boolean right = rec(root.right);
        if (!left) root.left = null;
        if (!right) root.right = null;

        return root.val == 1 || left || right;
    }

    public TreeNode pruneTree1(TreeNode root) {
        if (root == null)
            return null;

        // 先修剪左右子树
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 当前节点值为0，且是叶子节点，则需要修剪
        if (root.val == 0 && root.left == null && root.right == null)
            return null;

        return root;
    }
}
