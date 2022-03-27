package Top100;

/**
 * 排序链表
 */
public class LC148 {

    /**
     * 链表归并排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        int length = 0;
        ListNode node = head;
        while (node!=null) {
            length++;
            node= node.next;
        }

        ListNode dummyHead = new ListNode(0, head);

        // 归并部分
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;//curr 指向当前归并部分的第一个节点
            while (curr != null) {
                //一组归并操作中的第一部分
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next!=null; i++) {
                    curr = curr.next;
                }

                //一组归并操作种的第二部分
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr!=null && curr.next!=null; i++) {
                    curr = curr.next;
                }

                //处理curr 为下一组归并操作做准备
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }

                ListNode merged = mergeTwoLists(head1, head2);
                prev.next = merged;
                while (prev.next != null){
                    prev = prev.next;
                }

                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0),tail = head;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1!=null?l1:l2;

        return head.next;
    }
}
