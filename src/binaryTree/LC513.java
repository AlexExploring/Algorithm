package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值
 *
 * 和lC199,LC513,LC515 类似
 *
 * 题目：给定一个二叉树的 根节点 root，请找出该二叉树的 最底层
 * 最左边 节点的值。假设二叉树中至少有一个节点。
 */
public class LC513 {

    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ans = queue.peek().val;
            // 当前层的节点个数
            int currLevelCount = queue.size();
            for (int i = 0; i < currLevelCount; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
        return ans;
    }
}
