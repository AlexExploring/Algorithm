package JZOFII;

/**
 * 删除链表的倒数第n个节点
 */
public class JZ21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummyHead = new ListNode(0);
       dummyHead.next = head;

       ListNode fast = dummyHead,slow = dummyHead;

       while (n-- > 0) fast = fast.next;

       while (fast.next != null) {
           fast = fast.next;
           slow = slow.next;
       }

       slow.next = slow.next.next;

       return dummyHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}