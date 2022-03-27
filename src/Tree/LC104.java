package Tree;

/**
 * 二叉树的最大深度
 */
public class LC104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
