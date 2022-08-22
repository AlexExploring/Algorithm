package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表II
 *
 * 题目：给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 要求：不允许修改 链表。
 */
public class LC142 {

    /**
     * 方法一：哈希表
     */
    public ListNode detectCycle(ListNode head) {
        ListNode curr = head;
        Set<ListNode> visited = new HashSet<ListNode>();

        while (curr != null) {
            //如果当前节点在visited中，说明曾经访问过，返回当前节点
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
     * 方法二：快慢指针
     *
     * 无环则返回null，有环则返回
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) return null;
        ListNode slow = head,fast = head;

        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            //fast和slow相遇，则继续找到环的入口节点
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