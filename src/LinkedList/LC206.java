package LinkedList;

/**
 * ��ת����
 */
public class LC206 {

    public ListNode reverseList(ListNode head){
        //��������Ϊ�ջ���ֻ��һ���ڵ�
        if (head == null || head.next == null){
            return head;
        }
        //�ݹ鷴ת ������
        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //1->2->3->4->5 ��ת�� ���Կ�����1<-2<-3<-4<-5 ����һ������ pre��1�Ƶ�5
    public ListNode reverseList1(ListNode head) {
        ListNode next = null;//��ǰ�ڵ�ĺ�����������;����ᱻ�ضϣ���ֹ��Ϣ��ʧ��
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
