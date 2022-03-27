package JZOF.linkList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输出倒数k个几点组成的链表
 *
 * 该题没有头节点
 */

public class JZ22 {

    //先统计链表长度
    public static ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode count = head;
        int len = 0;
        while (count!=null) {
            count = count.next;
            len++;
        }
        int start = len-k;
        while (start!=0){
            head = head.next;
            start--;
        }
        return head;
    }

    //双指针
    public static ListNode getKthFromEnd2(ListNode head, int k){
        ListNode lef = head,rig = head;
        while (k!=0){
            rig = rig.next;k--;
        }

        while (rig!=null){
            lef = lef.next;
            rig = rig.next;
        }

        return lef;
    }

    //倒序输出倒数k个节点
    static int index = 0;
    public static ListNode getKthFromEnd(ListNode head, int k) {

        if (head==null) return null;
        Deque<Integer> stack = new ArrayDeque<>();
        while (head!=null){
            stack.push(head.val);
            head = head.next;
        }

        ListNode ansHead = new ListNode(stack.pop());
        ListNode flag = ansHead;
        k--;
        while (k!=0){
            if (!stack.isEmpty()){
                ListNode s = new ListNode(stack.pop());
                flag.next = s;flag = flag.next;
            }
            k--;
        }
        return ansHead;
    }
}
