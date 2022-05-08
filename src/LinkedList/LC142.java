package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * ��������II
 */
public class LC142 {

    /**
     * ����һ����ϣ��
     */
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            //�����ǰ�ڵ���visited�У�˵���������ʹ������ص�ǰ�ڵ�
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    /**
     * ������������ָ��
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) return null;
        ListNode slow = head,fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }else return null;

            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}