package binaryTree;

/**
 * ƽ�������
 */
public class LC110 {

    /**
     * �Զ����µĵݹ�
     *
     * �ݹ���ж����нڵ�����������ĸ߶Ȳ����1
     *
     * ʱ�临�Ӷ�O(n^2)
     * �ռ临�Ӷ�O(n)
     */
    public boolean isBalanced(TreeNode root) {
        // ��Ϊ�յĻ������Լ������ĸ߶ȣ�ֱ���ж���Ϊƽ�������
        if (root == null) return true;

        //isBalanced(root.left)&&isBalanced(root.right) �ݹ���ÿһ���ڵ�����������ĸ߶Ȳ�
        return (Math.abs(helper(root.left)-helper(root.right))<=1)&&isBalanced(root.left)&&isBalanced(root.right);
    }

    /**
     * ���ڼ������ĸ߶�
     */
    public int helper(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(helper(root.left),helper(root.right))+1;
    }

    public boolean isBalanced1(TreeNode root) {
        return recur(root) != -1;
    }

    /**
     * �Ե����ϵĵݹ�
     *
     * ˼·:˼·�ǶԶ�����������������ӵ���������������ȣ����ж�ĳ��������ƽ������ ����֦�� ��ֱ�����Ϸ��ء�
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
