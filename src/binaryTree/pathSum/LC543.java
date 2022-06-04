package binaryTree.pathSum;

/**
 * 二叉树的直径
 *
 * 题目：给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径
 * 长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不
 * 穿过根结点。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class LC543 {

    /**
     * 方法一:因为任意两个结点路径长度中的最大值，所以需要维护一个max用来记录
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    int max = 0;

    public int dfs(TreeNode root) {
        int left = root.left == null ? 0 : dfs(root.left) + 1;
        int right = root.right == null ? 0 : dfs(root.right) + 1;
        max = Math.max(max,(left+right));
        return Math.max(left,right);
    }
}


