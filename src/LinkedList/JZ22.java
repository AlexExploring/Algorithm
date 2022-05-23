package LinkedList;

/**
 * �������k��������ɵ�����
 */
public class JZ22 {

    /**
     * ����ָ��
     */
    public static ListNode getKthFromEnd(ListNode head, int k){
        ListNode fast = head,slow = head;

        //��ָ������k���������k+1���ڵ�
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }

        //����ָ��һ����
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * ��ͳ������ĳ���
     */
    public static ListNode getKthFromEnd1(ListNode head, int k) {
        int len = 0;
        ListNode node = null;

        for (node = head;node.next != null;node = node.next) {
            len++;
        }

        //node����ָ������k���ڵ�
        for (node = head;len > k;len--) {
            node = node.next;
        }

        return node;
    }
}
