package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在每个树行中找最大值
 *
 * 和lC199,LC513,LC515 类似
 */
public class LC515 {

    /**
     * 层序遍历
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Integer curLevelMaxVal = Integer.MIN_VALUE;
            // 当前层的节点个数
            int currLevelCount = queue.size();
            for (int i = 0; i < currLevelCount; i++) {
                TreeNode node = queue.poll();
                curLevelMaxVal = Math.max(curLevelMaxVal,node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(curLevelMaxVal);
        }

        return ans;
    }
}
