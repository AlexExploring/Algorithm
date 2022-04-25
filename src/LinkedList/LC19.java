package LinkedList;

import java.util.HashMap;

/**
 * 删除链表的倒数第n个节点，并且返回链表的头节点
 */
public class LC19 {

    /**
     *  用map记录链表节点对应的引用，
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int index = 1;
        while (tail!=null){
            map.put(index++,tail);
            tail = tail.next;
        }

        int des = index-n;
        if (des==1){
            return head.next;
        }
        ListNode pre = map.get(des-1);
        pre.next = map.get(des).next;
        return head;
    }

    /**
     *  快慢指针，快指针先走n步，然后快慢一起走，直到快指针走到最后，要注意的是可能是
     *  要删除第一个节点，这个时候可以直接返回head -> next
     *
     *  注意：n应该是 <= head的长度
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head==null||head.next==null) return null;
        ListNode fast = head,slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast==null) return head.next;
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}