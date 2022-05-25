package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ������������˫������
 */
public class JZ36 {

    /**
     * ����ʹ��ջ�Ķ������������
     *
     * ��ʱ1ms
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node head = null,tail = null,temp = null;

        while(!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                Node node = stack.pop();
                if (head==null){
                    head = node;tail = node;
                }else {
                    tail.right = node;
                    tail.right.left = tail;
                    tail = tail.right;
                }
                root = node.right;
            }
        }
        head.left = tail;
        tail.right = head;
        return head;
    }

    /**
     * ������
     */
    private Node tail = null;
    private Node head = null;

    public Node treeToDoublyList1(Node root) {
        if(root == null) return null;

        dfs(root);
        //��β����
        head.left = tail;
        tail.right = head;

        return head;
    }

    void dfs(Node cur) {
        if(cur == null) return;

        dfs(cur.left);

        if(tail != null) tail.right = cur;
        else head = cur;

        cur.left = tail;
        tail = cur;
        dfs(cur.right);
    }
}

