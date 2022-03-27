package JZOF.divideAndConquer;

public class JZ36 {
    public static void main(String[] args) {

    }

    public Node treeToDoublyList(Node root) {

        if (root!=null){
            treeToDoublyList(root.left);

            treeToDoublyList(root.right);
        }

        return null;
    }
}

class Node {
    public int val;
    public Node left;
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