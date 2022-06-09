package LinkedList;


public class Exercise {

    public ListNode sort(ListNode head) {
        if (head == null) return null;

        int len = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            len++;
        }

        ListNode dummyHead = new ListNode(0,head);

        for (int subLength = 1;subLength < len;subLength <<= 1) {
            ListNode prev = dummyHead,curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }

                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }

                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }

                ListNode merged = mergeTwoLists(head1, head2);

                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }

                curr = next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 合并两个有序链表为一个新的有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0),tail = head;

        while (l1 != null && l2 != null){
            if (l1.val  <=  l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 != null ? l1 : l2;

        return head.next;
    }
}
