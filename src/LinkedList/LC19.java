package LinkedList;

/**
 * ɾ������ĵ�����n���ڵ㣬���ҷ��������ͷ�ڵ�
 */
public class LC19 {

    /**
     *  ����ָ�룬��ָ������n����Ȼ�����һ���ߣ�ֱ����ָ���ߵ����Ҫע����ǿ�����
     *  Ҫɾ����һ���ڵ㣬���ʱ�����ֱ�ӷ���head -> next
     *
     *  ע�⣺nӦ���� <= head�ĳ���
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode slow = head,fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //��ʱslowָ������n+1���ڵ�
        slow.next = slow.next.next;

        return head;
    }
}

