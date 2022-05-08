package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 路径总和  LC112
 *
 * 注意点：判断该树中是否存在根节点到叶子结点的路径，这条路径上所有节点值相加等于目标个targetSum
 * 必须要遍历到叶子节点，中途不能返回
 *
 *
 * 相似题目；LC112 路径总和 I,LC113 路径总和 II, LC437 路径总和III
 */
public class LC112 {

    /**
     * 递归
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        dfs(root,targetSum);
        return flag;
    }

    boolean flag = false;

    public void dfs(TreeNode root, int targetSum) {
        if (root==null) return;

        if (root.left==null&&root.right==null){
            if (targetSum==root.val) flag = true;
        }else {
            if (root.left!=null){
                root.left.val+=root.val;
                dfs(root.left,targetSum);
            }
            if (root.right!=null){
                root.right.val+=root.val;
                dfs(root.right,targetSum);
            }
        }
    }

    /**
     * 递归  ， 写法2
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


    /**
     * 利用层序遍历
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
}
