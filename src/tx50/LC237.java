package tx50;

/**
 * ɾ�������еĽڵ�
 */
public class LC237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node = node.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}