package binaryTree;

/**
 *��һ����������
 *
 * ������ tree ��һ���������� tree ��ĳ���ڵ������ڵ�����к���ڵ㡣tree Ҳ���Կ����������һ������
 */

public class LC572 {
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root1==null||root2==null)
            return false;
        if (isSameTree(root1, root2))  //�ݹ����root1 ���Ա������Ľڵ�ȥ�����Ƿ��root2����ͬ����
            return true;
        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;
        else return p!=null && q!=null && p.val == q.val && (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right));
    }
}
