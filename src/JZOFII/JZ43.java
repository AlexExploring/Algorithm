package JZOFII;

import java.awt.geom.QuadCurve2D;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ����ȫ��������ӽڵ�
 */
public class JZ43 {

}

/**
 * �����������߽��в�����ջ����һ�߽��в���
 */
class CBTInserter {

    Queue<TreeNode> queue;
    TreeNode head;

    public CBTInserter(TreeNode root) {
        head = root;
        queue = new LinkedList<>();
        queue.offer(root);
        //�ҵ���һ�������
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = queue.peek();
        TreeNode cur = new TreeNode(v);
        //��ڵ�Ϊ��ֱ�Ӳ���
        if (node.left == null)
            node.left = cur;
            //�ҽڵ���Ҫ�����ڵ���ӣ����Һ������
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