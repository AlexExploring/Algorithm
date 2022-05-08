package LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 */
public class LC234 {

    /**
     * 将值复制到数组中后使用双指针判断是否回文
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }

        int l = 0,r = list.size()-1;
        while (l<=r){
            if (list.get(l)==list.get(r)){
                l++;r--;
            }else return false;
        }

        return true;
    }

    /**
     *
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = middleNode(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        //本题中保证了firstHalfEnd的长度是>=secondHalfStart的
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 看题目是否要求还原链表
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    /**
     * 反转链表
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 查找链表的中点
     */
    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
