package binaryTree.template;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ����ջ����������ģ��
 */
public class StackTraverseTemplate {

    /**
     * ǰ�����
     */
    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
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
     * �������
     */
    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //��������У���ջ�е����Ľڵ㣬���������Ƿ������ˣ�����ֱ�ӷ��ʸýڵ㣬Ȼ�������������������
            curr = stack.pop();
            System.out.println(curr.val);
            curr = curr.right;
        }
    }

    /**
     * �������
     */
    public void postOrderTraversal(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null,curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //��ĳ��������������Ժ󣬽��ž�Ҫ���ݵ��丸�ڵ�ȥ��
            //��������У���ջ�е����Ľڵ㣬����ֻ��ȷ�����������϶��������ˣ������޷�ȷ���������Ƿ���ʹ���
            //��ˣ������ں�������У�������һ��prev����¼��ʷ���ʼ�¼��1. ��������һ��������ʱ��������
            // prevָ��ýڵ㡣2. �������ڻ��ݵ����ڵ��ʱ�򣬿����ɴ����жϣ���һ�����ʵĽڵ��Ƿ�Ϊ������
            curr = stack.pop();
            //������Ҫȷ�������Ƿ����������������������Ƿ���ʹ�
            //���û���������������������������ˣ�Ҳ������һ�����ʵĽڵ������ӽڵ�ʱ
            if (curr.right == null || curr.right == prev) {
                // ���ʸ�
                System.out.println(curr.val);
                prev = curr;
                curr = null;
            }else {
                //������û�з�����ϣ�������Ҫ������ջ
                stack.push(curr);
                curr = curr.right;
            }
        }
    }
}
