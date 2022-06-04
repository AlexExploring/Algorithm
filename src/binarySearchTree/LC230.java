package binarySearchTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * �����������е�kС��Ԫ��
 */
public class LC230 {

    /**
     * �ݹ�������������¼��ǰ���������ǵڼ�����
     */
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    private int flag;
    private int ans;

    public void inOrder(TreeNode root, int k) {
        if (root != null && flag != k) {
            inOrder(root.left, k);
            flag++;
            if (flag == k) ans = root.val;
            inOrder(root.right, k);
        }
    }

    /**
     * ����ջ���������
     */
    public int kthSmallest1(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            --k;
            if (k == 0) break;
            curr = curr.right;
        }

        return curr.val;
    }
}