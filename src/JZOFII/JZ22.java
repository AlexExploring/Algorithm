package JZOFII;

import java.util.HashSet;
import java.util.Set;

/**
 * �����л�����ڽڵ�
 */
public class JZ22 {

    /**
     * ��ϣ��
     */
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    /**LC
     * ����ָ��
     */
    public ListNode detectCycle1(ListNode head) {
        return null;
    }
}
