package binaryTree;

/**
 * ƽ�������
 */
public class LC110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;  // ��Ϊ�յĻ������Լ������ĸ߶ȣ�ֱ���ж���Ϊƽ�������

        //isBalanced(root.left)&&isBalanced(root.right) �ݹ���ÿһ���ڵ�����������ĸ߶Ȳ�
        return (Math.abs(helper(root.left)-helper(root.right))<=1)&&isBalanced(root.left)&&isBalanced(root.right);
    }

    public int helper(TreeNode root) {
        if (root==null) return 0;
        else return Math.max(helper(root.left),helper(root.right))+1;
    }
}
