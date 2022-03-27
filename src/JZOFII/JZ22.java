package JZOFII;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表中环的入口节点
 */
public class JZ22 {

    /**
     * 哈希表
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
     * 快慢指针
     */
    public ListNode detectCycle1(ListNode head) {
        return null;
    }
}
