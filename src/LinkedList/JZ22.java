package LinkedList;

/**
 * 输出倒数k个几点组成的链表
 */
public class JZ22 {

    /**
     * 快慢指针
     */
    public static ListNode getKthFromEnd(ListNode head, int k){
        ListNode fast = head,slow = head;

        //快指针先走k步，到达第k+1个节点
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }

        //快慢指针一起走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 先统计链表的长度
     */
    public static ListNode getKthFromEnd1(ListNode head, int k) {
        int len = 0;
        ListNode node = null;

        for (node = head;node.next != null;node = node.next) {
            len++;
        }

        //node最终指向倒数第k个节点
        for (node = head;len > k;len--) {
            node = node.next;
        }

        return node;
    }
}
