package binaryTree;


/**
 * ��ͬ����
 */
public class LC100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;
        // p!=null && q!=null && p.val == q.val �ж�һ���ڵ�
        // (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right)) �ݹ��ж�����������ÿһ���ڵ�
        else return p!=null && q!=null && p.val == q.val && (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right));
    }

}
