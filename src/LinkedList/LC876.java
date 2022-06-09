package LinkedList;

/**
 * ������м�ڵ�
 *
 * ��Ŀ������һ��ͷ���Ϊ head �ķǿյ���������������м��㡣
 * ����������м��㣬�򷵻صڶ����м��㡣
 */
public class LC876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        return slow;
    }
}
