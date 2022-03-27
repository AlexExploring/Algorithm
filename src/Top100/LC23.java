package Top100;

import java.util.PriorityQueue;

/**
 * 合并kge升序链表
 */

public class LC23 {

    /**
     * 方法一   顺序合并
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode head = null;
        for (int i = 0; i < len; i++) {
            head = mergeTwoLists(head,lists[i]);
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0),tail = head;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1!=null?l1:l2;

        return head.next;
    }


    /**
     * 方法二  使用优先队列
     */

    public ListNode mergeKLists1(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
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
