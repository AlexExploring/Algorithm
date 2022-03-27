package Top100;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表  哈希set 快慢指针
 */
public class LC141 {

    /**
     * set
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     *  快慢指针
     */
    public boolean hasCycle1(ListNode head) {
        if (head==null||head.next==null) return false;

        ListNode slow = head,fast = head.next;
        while (slow!=fast) {
            if (fast==null || fast.next==null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
