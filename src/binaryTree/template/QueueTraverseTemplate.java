package binaryTree.template;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��������ʵ�֣����������
 */
public class QueueTraverseTemplate {

    /**
     * ������� ��������ʵ��
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
