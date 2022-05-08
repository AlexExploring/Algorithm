package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �������½ǵ�ֵ
 *
 * ��lC199,LC513,LC515 ����
 *
 * ��Ŀ������һ���������� ���ڵ� root�����ҳ��ö������� ��ײ�
 * ����� �ڵ��ֵ�������������������һ���ڵ㡣
 */
public class LC513 {

    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ans = queue.peek().val;
            // ��ǰ��Ľڵ����
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
