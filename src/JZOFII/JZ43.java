package JZOFII;

import java.awt.geom.QuadCurve2D;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 往完全二叉树添加节点
 */
public class JZ43 {

}

/**
 * 队列是在两边进行操作，栈是在一边进行操作
 */
class CBTInserter {

    Queue<TreeNode> queue;
    TreeNode head;

    public CBTInserter(TreeNode root) {
        head = root;
        queue = new LinkedList<>();
        queue.offer(root);
        //找到下一个插入点
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = queue.peek();
        TreeNode cur = new TreeNode(v);
        //左节点为空直接插入
        if (node.left == null)
            node.left = cur;
            //右节点需要将父节点出队，左右孩子入队
        else {
            node.right = cur;
            queue.poll();
            queue.add(node.left);
            queue.add(node.right);
        }
        return node.val;
    }

    public TreeNode get_root() {
        return head;
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