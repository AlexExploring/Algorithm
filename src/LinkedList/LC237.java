package LinkedList;

public class LC237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node = node.next.next;
    }
}