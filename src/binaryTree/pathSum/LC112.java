package binaryTree.pathSum;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ·���ܺ�  LC112
 *
 * ע��㣺�жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽ���·��������·�������нڵ�ֵ��ӵ���Ŀ���targetSum
 * ����Ҫ������Ҷ�ӽڵ㣬��;���ܷ���
 *
 * ������Ŀ��LC112 ·���ܺ� I,LC113 ·���ܺ� II, LC437 ·���ܺ�III
 */
public class LC112 {

    /**
     * dfs����
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //�ݹ�߽磬��ǰ�ڵ�Ϊnull���򲻴��򵽵�ǰ�ڵ��·��
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * ���ò������
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;

        //�������У��ֱ�洢��Ҫ�����Ľڵ㣬�Լ����ڵ㵽��Щ�ڵ��·����
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            //Ҷ�ӽڵ㣬��Ҫ�ж��Ƿ��ҵ�·��
            if (now.left == null && now.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }

        return false;
    }
}
