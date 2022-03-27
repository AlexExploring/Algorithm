package JZOFII;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ¶ş²æÊ÷µÄÓÒ²àÊÓÍ¼
 */
public class JZ46 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int currLevelCount = queue.size();
            for (int i = 0; i < currLevelCount; i++) {
                TreeNode node = queue.poll();
                if (i == currLevelCount-1) ans.add(node.val);
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
