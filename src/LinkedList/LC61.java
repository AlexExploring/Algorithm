package LinkedList;

/**
 * ��ת����
 *
 * ��Ŀ������һ�������ͷ�ڵ� head ����ת����������ÿ���ڵ������ƶ� k ��λ�á�
 */
public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int n = 1; // ����ͳ�������ܽ����
        ListNode tmp = head,newTail = head,newHead = null;
        while (tmp.next != null) {
            n++;
            tmp = tmp.next;
        }
        k %= n;
        // ��kΪ0ʱ������Ҫ��ת��
        if (k == 0) return head;

        // �����������������ؽ�������ת�������Ƚ���β����
        tmp.next = head;
        // ����ֻ��Ҫ�ҵ�������k+1���ڵ�
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
