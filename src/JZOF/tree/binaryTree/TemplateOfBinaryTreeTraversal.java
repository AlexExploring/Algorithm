package JZOF.tree.binaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TemplateOfBinaryTreeTraversal {

    /**
     * 递归实现
     */
    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 使用栈来实现
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
     *  递归实现
     */
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    /**
     *  借助栈实现
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
     * 注意到，前序遍历和后续遍历得到的顺序完全相反，如果只是需要得带正确结果的话,
     * 可以用list将前序遍历的结果存储起来，然后，将list反转，即可得到后续遍历的
     * 结果。
     *
     * 这里给出的是正规的迭代的后续遍历
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
            // 右子树访问完毕
            if (curr.right == null || curr.right == prev) {
                System.out.println(curr.val); // 访问根
                prev = curr;
                curr = null;
            }else {
                //右子树没有访问完毕，所以需要重新入栈
                stack.push(curr);
                curr = curr.right;
            }
        }
    }

    /**
     * 层序遍历 借助队列实现
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
