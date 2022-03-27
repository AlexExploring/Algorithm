package Math;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author zhxspacex
 * @date 2021/1/2 21:33
 */
public class LC2_LB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        ListNode headl1 = null,taill1 = null;
        for (int i = 0; i < n1; i++) {
            ListNode s = new ListNode();
            s.val = scan.nextInt();
            if (headl1==null){
                headl1 = s;
            }else {
                taill1.next = s;
            }
            taill1 = s;
        }
        taill1.next = null;
        System.out.println("l1创建完毕");
        ListNode headl2 = null,taill2 = null;
        for (int i = 0; i < n2; i++) {
            ListNode s = new ListNode();
            s.val = scan.nextInt();
            if (headl2==null){
                headl2 = s;
            }else {
                taill2.next = s;
            }
            taill2 = s;
        }
        taill2.next = null;
        System.out.println("l2创建完毕");
        ListNode ans = addTwoNumbers(headl1,headl2);
        ListNode p = ans;
        while (p!=null){
            System.out.print(p.val+" ");
            p = p.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null,tail = null;
        int t = 0;
        while (l1 != null||l2 != null){
            int d = 0;
            if (l1==null){
                d = l2.val+t;
            }else if (l2 == null){
                d = l1.val+t;
            }else {
                d = l1.val+l2.val+t;
            }
            ListNode s = new ListNode();
            if (d<10){
                s.val = d;
                t = 0;
            }else {
                s.val = d%10;
                t = d/10;
            }
            if (l1!=null)l1 = l1.next;
            if (l2!=null)l2 = l2.next;
            if (ans==null){
                ans = s;
            }else {
                tail.next = s;
            }
            tail = s;
        }
        if (t!=0){
            ListNode s = new ListNode();
            s.val = t;
            tail.next = s;
            tail = s;
        }
        tail.next = null;
        return ans;
    }

    /**
     *官方题解
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
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