package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �Գƶ�����
 *
 * ��Ŀ������һ���������ĸ��ڵ� root �� ������Ƿ���Գơ�
 */
public class LC101 {

    /**
     * �ݹ�ʵ��
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        //������Ϊ�գ�����true
        if (p == null && q == null) return true;
        //ֻ��һ��Ϊ�գ��򷵻�false
        if (p != null || q != null)  return false;

        //
        return (p.val == q.val) && isSymmetric(p.left,q.right) && isSymmetric(p.right,q.left);
    }

    /**
     * ���õ���ʵ��
     */
    public boolean isSymmetric1(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();

            if (p == null && q == null) continue;
            if ((p == null || q == null) || (p.val != q.val)) return false;

            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }

        return true;
    }
}
