package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��������������
 *
 * LC110�õ��˱���
 */
public class LC104 {

    /**
     * �ݹ�
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * �������
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int res = 0;

        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return res;
    }
}
