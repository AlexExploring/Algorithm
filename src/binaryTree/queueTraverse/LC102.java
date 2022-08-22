package binaryTree.queueTraverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ¶þ²æÊ÷µÄ²ãÐò±éÀú
 */
public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null) return ans;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> tans = new ArrayList<>();

        while (!queue.isEmpty()){
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++) {
                TreeNode temp = queue.poll();
                tans.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            ans.add(new ArrayList<>(tans));
            tans.clear();
        }

        return ans;
    }
}
