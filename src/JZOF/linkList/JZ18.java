package JZOF.linkList;

import java.util.Scanner;

/**
 *删除链表的节点
 *
 * 链表没有头节点 则首元节点需要单独处理
 */
public class JZ18 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    }

    //双指针
    public ListNode deleteNode1(ListNode head, int val) {
        if (head==null) return null;
        if(head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;  //说明找到了节点值和val相等的节点
        return head;
    }

    //单指针
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val)
            cur = cur.next;
        if (cur.next != null) cur.next = cur.next.next;
        return head;
    }

    //添加一个头节点 哑指针
    public ListNode deleteNode3(ListNode head, int val) {
        ListNode flag = new ListNode(-1);
        flag.next = head;
        ListNode cur = flag;
        while (cur.next!=null&&cur.next.val!=val){
            cur = cur.next;
        }
        if (cur.next!=null) cur.next = cur.next.next;
        return flag.next;
    }

    /**
     *递归实现
     *
     * 一直递归到有节点值和val相等的节点或到达链表尾部，
     * 再递归的将整个表连接起来
     */
    public ListNode deleteNode4(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next; //略过要删除的节点，即当前的head
        } else {
            head.next = deleteNode3(head.next, val);
        }
        return head;
    }
}

