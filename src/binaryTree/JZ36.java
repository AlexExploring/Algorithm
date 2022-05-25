package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树与双向链表
 */
public class JZ36 {

    /**
     * 借助使用栈的二叉树中序遍历
     *
     * 耗时1ms
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
     * 方法二
     */
    private Node tail = null;
    private Node head = null;

    public Node treeToDoublyList1(Node root) {
        if(root == null) return null;

        dfs(root);
        //首尾相连
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

