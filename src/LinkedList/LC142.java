package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * ��������II
 *
 * ��Ŀ������һ�������ͷ�ڵ�  head ����������ʼ�뻷�ĵ�һ���ڵ㡣 ��������޻����򷵻� null��
 *
 * Ҫ�󣺲������޸� ����
 */
public class LC142 {

    /**
     * ����һ����ϣ��
     */
    public ListNode detectCycle(ListNode head) {
        ListNode curr = head;
        Set<ListNode> visited = new HashSet<ListNode>();

        while (curr != null) {
            //�����ǰ�ڵ���visited�У�˵���������ʹ������ص�ǰ�ڵ�
            if (visited.contains(curr)) {
                return curr;
            } else {
                visited.add(curr);
            }
            curr = curr.next;
        }

        return null;
    }

    /**
     * ������������ָ��
     *
     * �޻��򷵻�null���л��򷵻�
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) return null;
        ListNode slow = head,fast = head;

        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            //fast��slow������������ҵ�������ڽڵ�
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

    }
}