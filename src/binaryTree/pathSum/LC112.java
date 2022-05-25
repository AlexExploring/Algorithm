package binaryTree.pathSum;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 路径总和  LC112
 *
 * 注意点：判断该树中是否存在根节点到叶子结点的路径，这条路径上所有节点值相加等于目标个targetSum
 * 必须要遍历到叶子节点，中途不能返回
 *
 * 相似题目；LC112 路径总和 I,LC113 路径总和 II, LC437 路径总和III
 */
public class LC112 {

    /**
     * dfs搜索
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //递归边界，当前节点为null，则不存则到当前节点的路径
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * 利用层序遍历
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;

        //两个队列，分别存储将要遍历的节点，以及根节点到这些节点的路径和
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            //叶子节点，需要判断是否找到路径
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
