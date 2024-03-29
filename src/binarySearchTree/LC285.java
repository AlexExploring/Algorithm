package binarySearchTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树中的中序后继
 */
public class LC285 {

    /**
     * 中序遍历过程中找到目标节点
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        boolean flag = false;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (flag) return curr;
            if (curr == p) flag = true;
            curr = curr.right;
        }
        return null;
    }

    /**
     * 由于题目只要求找出目标节点，根据二叉搜索树的性质，找到第一个比p的节点值大的节点
     */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        // 记录当前比 p 节点大的节点
        TreeNode res = null;
        TreeNode curr = root;
        // 在二叉搜索树中进行搜索
        while(curr != null){
            // 如果当前节点 > p，则更新当前比 p 节点大的节点 res , 同时去左子树进行搜索
            if(curr.val > p.val){
                res = curr;
                curr = curr.left;
            }else{// 如果当前节点 < p , 则到右子树进行搜索
                curr = curr.right;
            }
        }
        // 当搜寻结束后，res 指向的就是最近的比 p 节点大的节点。
        return res;
    }
}


