package JZOFII;

import java.util.Stack;

/**
 *  展平二叉搜索树
 */
public class JZ52 {

    private TreeNode resNode;

    /**
     * 递归实现
     */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        // 在中序遍历的过程中修改节点指向
        resNode.right = node;
        node.left = null;
        resNode = node;

        inorder(node.right);
    }

    public TreeNode increasingBST1(TreeNode root) {
        if (root == null) return null;

        TreeNode newRoot = null;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if (newRoot == null) newRoot = node;
            node.left = null;
            if (node.right == null) {
                if (!stack.isEmpty()) {
                    node.right = stack.peek();
                }

            } else {
                cur = node.right;
            }
        }

        return newRoot;
    }
}
