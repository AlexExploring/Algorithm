package JZOF.tree.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JZ55I {
    public static void main(String[] args) {

    }



    public int maxDepth(TreeNode root) {
        helper(root,0);
        return max;
    }

    int max = 0;
    public void helper(TreeNode root,int index) {
        if (root!=null){
            helper(root.left,index++);
            helper(root.right,index++);
        }else max = Math.max(max,index);
    }


    /**
     *对每一颗子树分别判断是左子树还是右子树的高度更高
     */
    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        int nLeft = maxDepth1(root.left);
        int nRight = maxDepth1(root.right);
        return nLeft > nRight ? nLeft + 1 : nRight + 1;
    }

    /**
     *层序遍历的思想
     */
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> queue = new LinkedList() {{ add(root); }}, tmp;
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }

    /**
     *优化maxDepth2
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }
}
