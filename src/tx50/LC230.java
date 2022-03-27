package tx50;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树中第k小的元素
 */
public class LC230 {
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