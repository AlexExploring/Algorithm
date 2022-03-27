package JZOFII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最底层最左边的值
 */
public class JZ45 {
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ans = queue.peek().val;
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
