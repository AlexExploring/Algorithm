package binaryTree;

import java.util.Stack;

/**
 * 递增顺序搜索树
 */
public class LC897 {
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

    /**
     * 迭代实现
     */
    public TreeNode increasingBST1(TreeNode root) {
        if (root == null) return null;

        //使用newRoot 指向新的根节点即可
        TreeNode newRoot = null;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();

            //指向根节点
            if (newRoot == null) newRoot = node;

            //断开当前节点和左子树的连接
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
