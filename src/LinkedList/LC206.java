package LinkedList;

/**
 * 反转链表
 */
public class LC206 {

    public ListNode reverseList(ListNode head){
        //当单链表为空或者只有一个节点
        if (head == null || head.next == null){
            return head;
        }
        //递归反转 子链表
        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //1->2->3->4->5 翻转后 可以看作是1<-2<-3<-4<-5 在这一过程中 pre从1移到5
    public ListNode reverseList1(ListNode head) {
        ListNode next = null;//当前节点的后驱，由于中途链表会被截断，防止信息丢失。
        ListNode pre = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
