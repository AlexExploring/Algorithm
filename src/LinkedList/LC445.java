package LinkedList;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 两数相加II
 */
public class LC445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        int carry = 0;
        ListNode head = null,next = null;
        while (l1 != null || l2 != null || carry != 0) {
            int value1 = l1 != null ? l1.val : 0;
            int value2 = l2 != null ? l2.val : 0;
            int sum = value1+value2+carry;
            carry = sum/10;
            head = new ListNode(sum%10,next);
            next = head;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return head;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry= 0;
        ListNode head = null,next = null;
        while (!stack1.isEmpty()||!stack2.isEmpty()||carry!=0) {
            int value1 = stack1.isEmpty() ? 0 : stack1.pop();
            int value2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = value1+value2+carry;
            carry = sum/10;
            head = new ListNode(sum%10,next);
            next = head;
        }

        return head;
    }
}
