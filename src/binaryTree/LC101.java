package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * 题目：给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class LC101 {

    /**
     * 递归实现
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        //两个都为空，返回true
        if (p == null && q == null) return true;
        //只有一个为空，则返回false
        if (p != null || q != null)  return false;
        //p,q都不为空，判断节点值是否相等，并递归判断
        //（）
        return (p.val == q.val)
                && isSymmetric(p.left,q.right)
                && isSymmetric(p.right,q.left);
    }

    /**
     * 层序遍历
     *
     * 一个从左到右加节点，一个从右到左加节点
     */
    public boolean isSymmetric1(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();

            if (p == null && q == null) continue;
            if ((p == null || q == null) || (p.val != q.val)) return false;

            //对称的将节点放入队列中
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }

        return true;
    }
}
