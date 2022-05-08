package binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ���������Ҳ���ͼ
 *
 * ��lC199,LC513,LC515 ����
 */
public class LC199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currLevelCount = queue.size();
            for (int i = 0; i < currLevelCount; i++) {
                TreeNode node = queue.poll();
                // ȡÿһ���е����Ҳ�ڵ�ֵ
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

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ans.add(queue.peekLast().val);
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
