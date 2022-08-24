package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 （相关题目LC142 环形链表II）
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
        //0个节点
        if (head == null) return false;
        ListNode slow = head,fast = head;

        while (true) {
            //无环
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
    }
}
