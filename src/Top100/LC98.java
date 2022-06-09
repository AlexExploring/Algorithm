package Top100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉搜索树
 */
public class LC98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root==null) return true;

        if (root.val<=lower||root.val>=upper) return false;

        return isValidBST(root.left,lower,root.val)&&isValidBST(root.right,root.val,upper);
    }

    /**
     * 中序遍历
     */
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = Long.MIN_VALUE;

        while (!stack.isEmpty()||root!=null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.val<=inorder) return false;

            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
