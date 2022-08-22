package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 *
 * 相关题目LC111：二叉树的最小深度; LC110平衡二叉树
 */
public class LC104 {

    /**
     * 递归
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    /**
     * 层序遍历,统计有多少层
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
