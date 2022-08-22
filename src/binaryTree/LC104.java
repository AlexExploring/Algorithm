package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��������������
 *
 * �����ĿLC111������������С���; LC110ƽ�������
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
     * �������,ͳ���ж��ٲ�
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int res = 0;

        while (!queue.isEmpty()) {
            res++;
            for (int i = queue.size(); i >= 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return res;
    }
}
