package JZOFII;

import java.util.Stack;

/**
 *  չƽ����������
 */
public class JZ52 {

    private TreeNode resNode;

    /**
     * �ݹ�ʵ��
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

        // ����������Ĺ������޸Ľڵ�ָ��
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
