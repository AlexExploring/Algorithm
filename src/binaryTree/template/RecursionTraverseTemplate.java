package binaryTree.template;

/**
 * �ݹ鷽ʽ����������
 */
public class RecursionTraverseTemplate {

    /**
     * ǰ�����
     */
    public void preOrderTraversal(TreeNode root) {
        if (root != null){
            System.out.println(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /**
     * �������
     */
    public void inOrderTraversal(TreeNode root) {
        if (root != null){
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

    /**
     * �������
     */
    public void postOrderTraversal(TreeNode root) {
        if (root != null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

