package tx50;

/**
 * 旋转链表
 */
public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;

        ListNode tail = head,newTail = head,newHead = null;

        //计算链表长度
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        //首尾相连
        tail.next = head;
        //找到断开的位置
        for (int i = 0; i < (n - k%n - 1); i++) {
            newTail = newTail.next;
        }
        //使newHead只想正确的位置
        newHead = newTail.next;
        //断开
        newTail.next = null;

        return newHead;
    }
}
