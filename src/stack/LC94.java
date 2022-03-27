package stack;

import java.util.ArrayList;
import java.util.List;

/**
 *二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
*/
public class LC94 {
    public static void main(String[] args) {

    }

    /**
    *递归方法
    */
    public List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null){
            inorderTraversal(root.left);
            ans.add(root.val);
            inorderTraversal(root.right);
        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}