package binarySearchTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉搜索树
 */
public class LC98 {

    /**
     * 方法一：
     *
     * 设计一个递归函数 helper(root, lower, upper) 来递归判断，函数表示考虑以 root 为根的子树，判断子树中所有节点的值是否
     * 都在 (l,r) 的范围内（注意是开区间）。如果 root 节点的值 val 不在 (l,r) 的范围内说明不满足条件直接返回，否则我们要继
     * 续递归调用检查它的左右子树是否满足，如果都满足才说明这是一棵二叉搜索树。
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) return true;

        if (root.val <= lower || root.val >= upper) return false;

        return isValidBST(root.left,lower,root.val) && isValidBST(root.right,root.val,upper);
    }

    /**
     * 中序遍历
     *
     * 二叉搜索树的中序遍历的结果一定是一个升序序列
     */
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        //记录之前遍历到的节点的值
        double inorder = Long.MIN_VALUE;

        while (!stack.isEmpty() || curr != null){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (curr.val <= inorder) return false;
            inorder = curr.val;
            curr = curr.right;
        }

        return true;
    }
}
