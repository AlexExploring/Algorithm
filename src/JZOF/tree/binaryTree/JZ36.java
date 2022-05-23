package JZOF.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树与双向链表
 */
public class JZ36 {
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
                    temp = tail;
                    tail.right = node;
                    tail = tail.right;
                    tail.left = temp;
                }
                root = node.right;
            }
        }
        head.left = tail;
        tail.right = head;
        return head;
    }
}

class Node {
    public int val;

    // 链接前驱
    public Node left;
    // 链接后继
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}