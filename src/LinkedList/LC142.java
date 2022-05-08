package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表II
 */
public class LC142 {

    /**
     * 方法一：哈希表
     */
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            //如果当前节点在visited中，说明曾经访问过，返回当前节点
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
     * 方法二：快慢指针
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