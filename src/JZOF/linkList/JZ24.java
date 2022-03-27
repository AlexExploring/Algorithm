package JZOF.linkList;

/**
 *������ת
 *
 * �ٷ���⣺https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/fan-zhuan-lian-biao-by-leetcode-solution-jvs5/
 */

public class JZ24 {
    public static void main(String[] args) {

    }

    //����
    //ÿ��ʹ��head.next = pre;���½ڵ�;ɽڵ�����������Ȼ���ٽ�preָ��ոռ�����½ڵ㣬�ȴ���һ�β���
    public ListNode reverseList(ListNode head) {
        ListNode next = null;//��ǰ�ڵ�ĺ�����������;����ᱻ�ضϣ���ֹ��Ϣ��ʧ��
        ListNode pre = null;
        while (head != null){
            next = head.next;
            //��ǰ�ڵ�ĺ���ָ��ǰ��
            head.next = pre;
            //����preָ���λ�ã���ʼʱpreָ��null
            pre = head;
            //������һ���ڵ�
            head = next;
        }
        return pre;
    }

    //�ݹ�
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head; //����Ѿ���newHead.nextָ����head
        head.next = null;//��headָ��null
        return newHead;
    }
}
