package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 *
 * 题目：给你一个链表的头节点 head ，判断链表中是否有环。如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 数据范围：
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
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
        //为head为null或只有一个节点
        if (head == null || head.next == null) return false;

        ListNode slow = head,fast = head.next;

        //如果存在环，那么在环中一定会相遇，即slow = fast
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
