package JZOFII;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树每层的最大值
 */
public class JZ44 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Integer curLevelMaxVal = Integer.MIN_VALUE;
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
