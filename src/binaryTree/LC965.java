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

