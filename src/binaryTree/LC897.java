package binaryTree;

import java.util.Stack;

/**
 * ����˳��������
 */
public class LC897 {
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

    /**
     * ����ʵ��
     */
    public TreeNode increasingBST1(TreeNode root) {
        if (root == null) return null;

        //ʹ��newRoot ָ���µĸ��ڵ㼴��
        TreeNode newRoot = null;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();

            //ָ����ڵ�
            if (newRoot == null) newRoot = node;

            //�Ͽ���ǰ�ڵ��������������
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
