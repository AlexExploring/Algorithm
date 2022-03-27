package Top100;

import java.util.HashSet;
import java.util.Set;

/**
 * ª∑–Œ¡¥±Ì2
 */
public class LC142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head!=null) {
            if (!seen.add(head)) return head;
            else head = head.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head,fast = head;
        while (true) {
            if (fast==null||fast.next==null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow) break;
        }
        fast = head;
        while (fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
