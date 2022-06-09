package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 * 题目：给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交
 * 的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class LC160 {

    /**
     * 哈希表
     *
     * 时间复杂度O(m+n)
     * 空间复杂度O(m)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (!set.add(temp)) return temp;
            else temp = temp.next;
        }

        return null;
    }

    /**
     * 双指针
     *
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        //即使两链表不相交，最终也会相等,同时为null
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
