package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树插入器
 */
public class LC919 {

}

/**
 * 基于队列进行设计
 */
class CBTInserter {

    Queue<TreeNode> queue;
    TreeNode root;

    /**
     * 初始化的时候需要做一些预处理，方便后续插入新值
     */
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        //找到最后一层，新节点插入的位置
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int v) {
        //插入节点的父节点
        TreeNode node = queue.peek();
        //插入节点
        TreeNode cur = new TreeNode(v);
        //父节点的左节点为空直接插入
        if (node.left == null)
            node.left = cur;
            //左节点不为空需要将父节点出队，左右孩子入队
        else {
            node.right = cur;
            queue.poll();
            queue.add(node.left);
            queue.add(node.right);
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
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