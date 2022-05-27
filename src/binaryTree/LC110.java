package binaryTree;

/**
 * 平衡二叉树
 */
public class LC110 {

    /**
     * 自顶向下的递归
     *
     * 递归的判断所有节点的左右子树的高度差不超过1
     *
     * 时间复杂度O(n^2)
     * 空间复杂度O(n)
     */
    public boolean isBalanced(TreeNode root) {
        // 树为空的话不可以计算它的高度，直接判断其为平衡二叉树
        if (root == null) return true;

        //isBalanced(root.left)&&isBalanced(root.right) 递归检查每一个节点的左右子树的高度差
        return (Math.abs(helper(root.left)-helper(root.right))<=1)&&isBalanced(root.left)&&isBalanced(root.right);
    }

    /**
     * 用于计算树的高度
     */
    public int helper(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(helper(root.left),helper(root.right))+1;
    }

    public boolean isBalanced1(TreeNode root) {
        return recur(root) != -1;
    }

    /**
     * 自底向上的递归
     *
     * 思路:思路是对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
     */
    private int recur(TreeNode root) {
        if (root == null) return 0;

        int left = recur(root.left);
        if(left == -1) return -1;

        int right = recur(root.right);
        if(right == -1) return -1;

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
