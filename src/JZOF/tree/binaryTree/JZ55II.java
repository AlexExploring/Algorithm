package JZOF.tree.binaryTree;

/**
 *平衡二叉树
 */
public class JZ55II {
    public static void main(String[] args) {

    }

    /**
     *自底向顶，只有有一颗子树不满足平衡二叉树，则该二叉树不是平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root) !=-1;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;
        int nLeft = helper(root.left);
        int nRight = helper(root.right);
        if (nLeft==-1||nRight==-1) return -1;
        return Math.abs(nLeft-nRight)<2 ? Math.max(nLeft,nRight)+1 : -1;
    }

    /**
     *自顶向底，思路是构造一个获取当前子树深度的函数depth(root),通过比较某
     * 子树的左右子树的深度差，来判断某子树是否是平衡二叉树，若所
     * 有子树都平衡，则此树平衡
     */


}
