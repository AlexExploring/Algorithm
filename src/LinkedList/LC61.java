package LinkedList;

/**
 * 旋转链表
 *
 * 题目：给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int n = 1; // 用来统计链表总结点数
        ListNode tmp = head,newTail = head,newHead = null;
        while (tmp.next != null) {
            n++;
            tmp = tmp.next;
        }
        k %= n;
        // 当k为0时，不需要旋转，
        if (k == 0) return head;

        // 不满足上述条件，必将进行旋转，所以先将首尾相连
        tmp.next = head;
        // 现在只需要找到倒数第k+1个节点
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
