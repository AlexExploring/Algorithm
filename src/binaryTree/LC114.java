package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树展开为链表
 */
public class LC114 {

    /**
     * 按照前序遍历的顺序存储二叉树每一个节点，最后再连接为链表
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
     * 前序遍历和展开同步进行
     */
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        //prev 上一个访问的节点
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }

            TreeNode left = curr.left, right = curr.right;
            //因为栈是先进后出，为了保证先序遍历的顺序，先把右节点入栈，再把左节点入栈
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
     * 寻找前驱节点
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
