package binaryTree;

/**
 * 二叉树剪枝
 */
public class LC814 {

    public TreeNode pruneTree(TreeNode root) {
        return recur(root) ? root : null;
    }

    /**
     * 判断以root节点为根节点的子树是否包含1
     */
    public boolean recur(TreeNode root) {
        // 边界条件，root 为 null 返回false
        if (root == null) return false;
        boolean left = recur(root.left);
        boolean right = recur(root.right);
        if (!left) root.left = null;
        if (!right) root.right = null;

        return root.val == 1 || left || right;
    }

    /**
     * 自底向上的逐步剪枝
     */
    public TreeNode pruneTree1(TreeNode root) {
        if (root == null) return null;

        // 先修剪左右子树
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 当前节点值为0，且是叶子节点，则需要修剪
        if (root.val == 0 && root.left == null && root.right == null)
            return null;

        return root;
    }
}
