package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ������չ��Ϊ����
 */
public class LC114 {

    /**
     * ����ǰ�������˳��洢������ÿһ���ڵ㣬���������Ϊ����
     */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                list.add(curr);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }

        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), node = list.get(i);
            prev.left = null;
            prev.right = node;
        }
    }

    /**
     * ǰ�������չ��ͬ������
     */
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        //prev ��һ�����ʵĽڵ�
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }

            TreeNode left = curr.left, right = curr.right;
            //��Ϊջ���Ƚ������Ϊ�˱�֤���������˳���Ȱ��ҽڵ���ջ���ٰ���ڵ���ջ
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }

            prev = curr;
        }
    }

    /**
     * Ѱ��ǰ���ڵ�
     */
    public void flatten2(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
