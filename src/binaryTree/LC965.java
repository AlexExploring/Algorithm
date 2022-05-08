package binaryTree;

/**
 * ��ֵ������
 */
public class LC965 {

    /**
     * ���Ա��������������������ڵ��ֵ���뵽һ��set�����У�������set�Ĵ�С���ж�
     * �������Ƿ�Ϊ��ֵ������
     */

    public boolean isUnivalTree(TreeNode root) {
        if (root==null)
            return true;
        //�����ڵ㲻Ϊ�գ�������ڵ��ֵ��root�ڵ��ֵ�����
        if ((root.left!=null&&root.left.val!=root.val)||(root.right!=null&&root.right.val!=root.val))
            return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
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