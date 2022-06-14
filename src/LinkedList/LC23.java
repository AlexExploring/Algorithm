package LinkedList;

import java.util.PriorityQueue;

/**
 * 合并K个升序链表
 *
 * LC21 合并两个有序链表为一个更长的有序链表
 */
public class LC23 {

    /**
     * 方法一：每次合并两个链表，直到所有链表都被合并  耗时105ms
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode head = null;
        for (int i = 0; i < len; i++) {
            head = mergeTwoLists(head,lists[i]);
        }
        return head;
    }

    /**
     * 方法二： 分治归并  耗时1ms
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }else if (l > r) {
            return null;
        }

        int mid = (l + r) >> 1;

        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0),tail = head;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 != null ? l1 : l2;

        return head.next;
    }

    /**
     * 方法三 :使用优先队列  耗时4ms
     *
     * 思路：维护当前每个链表没有被合并的元素的最前面一个，k 个链表就最多有 k
     * 个满足这样条件的元素，每次在这些元素里面选取 val 属性最小的元素合并到答
     * 案中。
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (!queue.isEmpty()) {
            Status curr = queue.poll();
            tail.next = curr.ptr;
            tail = tail.next;
            if (curr.ptr.next != null) {
                queue.offer(new Status(curr.ptr.next.val, curr.ptr.next));
            }
        }

        return head.next;
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }
}
