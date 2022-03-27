package JZOF.tree.binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TemplateOfBinaryTreeTraversal {

    /**
     * �ݹ�ʵ��
     */
    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * ʹ��ջ��ʵ��
     */
    public void preOrder1(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()) {
            while (curr != null) {
                System.out.println(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }

    /**
     *  �ݹ�ʵ��
     */
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     *  ����ջʵ��
     */
    public void inOrder1(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.println(curr.val);
            curr = curr.right;
        }
    }

    public void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    /**
     * ע�⵽��ǰ������ͺ��������õ���˳����ȫ�෴�����ֻ����Ҫ�ô���ȷ����Ļ�,
     * ������list��ǰ������Ľ���洢������Ȼ�󣬽�list��ת�����ɵõ�����������
     * �����
     *
     * ���������������ĵ����ĺ�������
     */
    public void postOrder1(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null,curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            // �������������
            if (curr.right == null || curr.right == prev) {
                System.out.println(curr.val); // ���ʸ�
                prev = curr;
                curr = null;
            }else {
                //������û�з�����ϣ�������Ҫ������ջ
                stack.push(curr);
                curr = curr.right;
            }
        }
    }

    /**
     * ������� ��������ʵ��
     */
    public void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
}
