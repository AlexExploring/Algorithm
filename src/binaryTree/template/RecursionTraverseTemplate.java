package binaryTree.template;

/**
 * 递归方式遍历二叉树
 */
public class RecursionTraverseTemplate {

    /**
     * 前序遍历
     */
    public void preOrderTraversal(TreeNode root) {
        if (root != null){
            System.out.println(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal(TreeNode root) {
        if (root != null){
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal(TreeNode root) {
        if (root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

}



