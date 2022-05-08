package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��ȫ������������
 */
public class LC919 {

}

/**
 * ���ڶ��н������
 */
class CBTInserter {

    Queue<TreeNode> queue;
    TreeNode root;

    /**
     * ��ʼ����ʱ����Ҫ��һЩԤ�����������������ֵ
     */
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        //�ҵ����һ�㣬�½ڵ�����λ��
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public int insert(int v) {
        //����ڵ�ĸ��ڵ�
        TreeNode node = queue.peek();
        //����ڵ�
        TreeNode cur = new TreeNode(v);
        //���ڵ����ڵ�Ϊ��ֱ�Ӳ���
        if (node.left == null)
            node.left = cur;
            //��ڵ㲻Ϊ����Ҫ�����ڵ���ӣ����Һ������
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