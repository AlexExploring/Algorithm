package tx50;

/**
 * ��ת����
 */
public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) return head;

        ListNode tail = head,newTail = head,newHead = null;

        //����������
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        //��β����
        tail.next = head;
        //�ҵ��Ͽ���λ��
        for (int i = 0; i < (n - k%n - 1); i++) {
            newTail = newTail.next;
        }
        //ʹnewHeadֻ����ȷ��λ��
        newHead = newTail.next;
        //�Ͽ�
        newTail.next = null;

        return newHead;
    }
}
