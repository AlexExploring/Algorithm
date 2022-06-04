package binaryTree;

/**
 * 合并二叉树
 */
public class LC617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // root1为空的话，返回root2，如果root2本来也为空，则不影响结果
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        if (root1 != null && root2 != null)
            root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        //返回合并后节点
        return root1;
    }
}
