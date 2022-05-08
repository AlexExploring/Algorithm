package binaryTree.template;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 借助栈遍历二叉树模板
 */
public class StackTraverseTemplate {

    /**
     * 前序遍历
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
     * 中序遍历
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
            //中序遍历中，从栈中弹出的节点，其左子树是访问完了，可以直接访问该节点，然后接下来访问右子树。
            curr = stack.pop();
            System.out.println(curr.val);
            curr = curr.right;
        }
    }

    /**
     * 后序遍历
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
            //在某颗子树访问完成以后，接着就要回溯到其父节点去。
            //后序遍历中，从栈中弹出的节点，我们只能确定其左子树肯定访问完了，但是无法确定右子树是否访问过。
            //因此，我们在后序遍历中，引入了一个prev来记录历史访问记录。1. 当访问完一棵子树的时候，我们用
            // prev指向该节点。2. 这样，在回溯到父节点的时候，可以由此来判断，上一个访问的节点是否为右子树
            curr = stack.pop();
            //现在需要确定的是是否有右子树，或者右子树是否访问过
            //如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时
            if (curr.right == null || curr.right == prev) {
                // 访问根
                System.out.println(curr.val);
                prev = curr;
                curr = null;
            }else {
                //右子树没有访问完毕，所以需要重新入栈
                stack.push(curr);
                curr = curr.right;
            }
        }
    }
}
