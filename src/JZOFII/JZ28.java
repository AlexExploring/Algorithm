package JZOFII;

/**
 * 展开多级双向链表
 */
public class JZ28 {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node sub = flatten(curr.child);
                curr.child = null;
                Node temp = curr.next;
                curr.next = sub;
                sub.prev = curr;
                while (curr.next != null){
                    curr = curr.next;
                }
                if (temp == null) {
                    curr.next = null;
                }else {
                    curr.next = temp;
                    temp.prev = curr;
                }
            }else {
                curr = curr.next;
            }
        }
        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}