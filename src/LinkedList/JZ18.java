package LinkedList;

import java.util.Scanner;

/**
 * 删除链表的节点
 *
 * 链表没有头节点 则首元节点需要单独处理
 */
public class JZ18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    }

    /**
     * 双指针
     */
    public ListNode deleteNode1(ListNode head, int val) {
        if (head==null) return null;
        if(head.val == val) return head.next;

        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }

        //说明找到了节点值和val相等的节点，需要删除cur指向的节点
        if(cur != null) pre.next = cur.next;

        return head;
    }

    /**
     * 单指针
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;

        ListNode cur = head;
        while (cur.next != null && cur.next.val != val){
            cur = cur.next;
        }

        if (cur.next != null) cur.next = cur.next.next;

        return head;
    }
}

