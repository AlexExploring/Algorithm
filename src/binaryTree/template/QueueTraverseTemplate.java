package binaryTree.template;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 借助队列实现（层序遍历）
 */
public class QueueTraverseTemplate {

    /**
     * 层序遍历 借助队列实现
     */
    public void levelTraverse(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
}
