package JZOF.tree.binaryTree;

public class JZ36_1 {
    Node tail, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
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
