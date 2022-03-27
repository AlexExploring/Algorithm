package JZOF.linkList;

/**
 *单链表反转
 *
 * 官方题解：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/fan-zhuan-lian-biao-by-leetcode-solution-jvs5/
 */

public class JZ24 {
    public static void main(String[] args) {

    }

    //迭代
    //每次使用head.next = pre;将新节点和旧节点连接起来，然后再将pre指向刚刚加入的新节点，等待下一次操作
    public ListNode reverseList(ListNode head) {
        ListNode next = null;//当前节点的后驱，由于中途链表会被截断，防止信息丢失。
        ListNode pre = null;
        while (head != null){
            next = head.next;
            //当前节点的后驱指向前驱
            head.next = pre;
            //更新pre指向的位置，初始时pre指向null
            pre = head;
            //处理下一个节点
            head = next;
        }
        return pre;
    }

    //递归
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head; //这里，已经让newHead.next指向了head
        head.next = null;//让head指向null
        return newHead;
    }
}
